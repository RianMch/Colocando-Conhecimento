package br.com.bibliteca.domian.dto.author;

import br.com.bibliteca.domian.author.Author;
import br.com.bibliteca.domian.author.Book;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record AuthorDetailsDTO(@NotNull Long id, String name, String nationality, LocalDate DateOfBirth, List<Book>bookList) {
    public AuthorDetailsDTO(Author author){
        this(author.getId(), author.getName(), author.getNationality(), author.getDateOfBirth(),author.getBookList());

    }
}
