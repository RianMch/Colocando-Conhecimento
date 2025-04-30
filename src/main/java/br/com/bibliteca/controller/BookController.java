package br.com.bibliteca.controller;

import br.com.bibliteca.domian.author.Book;
import br.com.bibliteca.domian.dto.book.BookDto;
import br.com.bibliteca.domian.repository.RepositoryBook;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping ("/book")
public class BookController {
    @Autowired
    private RepositoryBook book;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid BookDto bookDto, UriComponentsBuilder builder){
        var book=new Book(bookDto);


    }

}
