package br.com.bibliteca.domian.dto.author;

import br.com.bibliteca.domian.author.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record AuthorDto(@NotBlank(message = "name")String name,
                        @NotBlank(message = "nationality")String nationality,
                        @NotNull(message = "DateOfBirth") LocalDate DateOfBirth,
                        List<Book>list
                        ) {
}
