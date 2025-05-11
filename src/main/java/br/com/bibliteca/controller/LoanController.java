package br.com.bibliteca.controller;

import br.com.bibliteca.domian.dto.Loan.LoanDetailsDto;
import br.com.bibliteca.domian.dto.Loan.LoanDto;
import br.com.bibliteca.domian.dto.Loan.LoanListingDto;
import br.com.bibliteca.domian.repository.RepositoryAuthor;
import br.com.bibliteca.domian.repository.RepositoryBook;
import br.com.bibliteca.domian.repository.RepositoryLoan;
import br.com.bibliteca.domian.repository.RepositoryUser;
import br.com.bibliteca.domian.role.Loan;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private RepositoryUser repositoryUser;
    @Autowired
    private RepositoryBook repositoryBook;
    @Autowired
    private RepositoryLoan repositoryLoan;

@PostMapping
    @Transactional
    public ResponseEntity realizarEmprestimo(@RequestBody @Valid LoanDto dto, UriComponentsBuilder builder){
    var user = repositoryUser.findById(dto.userID()).orElseThrow(()-> new IllegalArgumentException("Usuário não Encontrado"));
    var book = repositoryBook.findById(dto.bookId()).orElseThrow(()->new IllegalArgumentException("Livro não Encontrado"));

    if(!book.isAtivo()|| book.getQuantityTotal()<1){
        return ResponseEntity.badRequest().body("Livro não disponivel");
    }
    Loan loan = new Loan(user,book);
    repositoryLoan.save(loan);

    book.reduzirEstoque();
    var uri=builder.path("/loan/{id}").buildAndExpand(loan.getId()).toUri();
    return ResponseEntity.created(uri).body(new LoanDetailsDto(loan));
}
@GetMapping
public ResponseEntity<Page<LoanListingDto>> list(@PageableDefault(size = 10,sort={"id"},page = 0), Pageable pageable){
    var page =repositoryLoan.findByAtivoTrue(pageable).map(LoanListingDto::new);
    return ResponseEntity.ok(page);
}

}
