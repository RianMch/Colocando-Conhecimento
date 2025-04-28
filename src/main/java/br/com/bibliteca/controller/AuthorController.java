package br.com.bibliteca.controller;

import br.com.bibliteca.domian.author.Author;
import br.com.bibliteca.domian.dto.author.AuthorDto;
import br.com.bibliteca.domian.repository.RepositoryAuthor;
import br.com.bibliteca.domian.dto.author.AuthorDetailsDTO;
import br.com.bibliteca.domian.dto.author.AuthorListinDto;
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
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private RepositoryAuthor repositoryAuthor;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid AuthorDto authorDto, UriComponentsBuilder uriComponentsBuilder){
        var author=new Author(authorDto);
        repositoryAuthor.save(author);
        var uri=uriComponentsBuilder.path("/author/{id}").buildAndExpand(author.getId()).toUri();
        return ResponseEntity.created(uri).body(new AuthorDetailsDTO(author));
    }

    @GetMapping
    public ResponseEntity<Page<AuthorListinDto>>list(@PageableDefault(size = 10,sort ={"id"},page = 0)
    Pageable pageable){
        var author=repositoryAuthor.findByAtivoTrue(pageable).map(AuthorListinDto::new);
        return ResponseEntity.ok(author);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var author=repositoryAuthor.getReferenceById(id);
        author.delete();
        return ResponseEntity.noContent().build();
    }

}
