package br.com.bibliteca.domian.dto.author;

import br.com.bibliteca.domian.author.Author;
import br.com.bibliteca.domian.author.Book;
import br.com.bibliteca.domian.author.Genre;
import br.com.bibliteca.domian.dto.book.BookDto;
import ch.qos.logback.core.joran.spi.NoAutoStart;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record AuthorDto(@NotBlank(message = "name")String name,
                        @NotBlank(message = "nationality")String nationality,
                        @NotNull(message = "DateOfBirth") LocalDate dateOfBirth,
                        @NotNull(message = "Genre") Genre genre

                        ) {
    public AuthorDto(Author author){
        this(author.getName(), author.getNationality(),author.getDateOfBirth(),author.getGenre());
    }


}
