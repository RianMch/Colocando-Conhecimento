package br.com.bibliteca.domian.dto.author;

import br.com.bibliteca.domian.author.Author;
import br.com.bibliteca.domian.author.Book;

import java.time.LocalDate;
import java.util.List;

public record AuthorListinDto(Long id, String name, String nationality, LocalDate DateOfBirth) {
    public AuthorListinDto(Author author){
        this(author.getId(), author.getName(),author.getNationality(),author.getDateOfBirth());
    }
}
