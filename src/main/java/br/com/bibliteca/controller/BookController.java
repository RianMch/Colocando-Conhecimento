package br.com.bibliteca.controller;

import br.com.bibliteca.domian.author.Book;
import br.com.bibliteca.domian.dto.book.BookDetailsDTO;
import br.com.bibliteca.domian.dto.book.BookDto;
import br.com.bibliteca.domian.dto.book.BookListinDto;
import br.com.bibliteca.domian.dto.book.UpdateBookDto;
import br.com.bibliteca.domian.repository.RepositoryAuthor;
import br.com.bibliteca.domian.repository.RepositoryBook;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping ("/book")
public class BookController {
    @Autowired
    private RepositoryBook repositoryBook;
    @Autowired
    private RepositoryAuthor repositoryAuthor;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid BookDto bookDto, UriComponentsBuilder builder){
        var author=repositoryAuthor.findById(bookDto.authorID()).orElseThrow(()-> new IllegalArgumentException("Autor não encontrado"));
        var book=new Book(bookDto,repositoryAuthor);
        repositoryBook.save(book);
        var uri=builder.path("/book/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(new BookDetailsDTO(book));
    }
@Transactional
@PutMapping()
    public ResponseEntity Update(@RequestBody @Valid UpdateBookDto updateBookDto){
        var book = repositoryBook.getReferenceById(updateBookDto.id());
        book.update(updateBookDto);
        return ResponseEntity.ok(new BookDetailsDTO(book));
    }
@GetMapping
    public ResponseEntity<Page<BookListinDto>> list(@PageableDefault(size = 10,page = 0,sort = {"id"}) Pageable pageable){
    var page =repositoryBook.findByAtivoTrue(pageable).map(BookListinDto::new );
    return ResponseEntity.ok(page);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        var book = repositoryBook.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
        book.delete();
        return ResponseEntity.noContent().build();
    }

}
