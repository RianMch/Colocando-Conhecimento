package br.com.bibliteca.domian.dto.book;

import br.com.bibliteca.domian.author.Author;
import br.com.bibliteca.domian.author.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookDto(@NotBlank String title,
                      @NotBlank String isbn,
                      @NotNull int quantityTotal,
                      @NotNull int quantityAvailable,
                      @NotBlank Genre genre,
                      @NotBlank Author author) {
}
