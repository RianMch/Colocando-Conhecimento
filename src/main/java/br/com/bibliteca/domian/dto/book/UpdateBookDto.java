package br.com.bibliteca.domian.dto.book;

import br.com.bibliteca.domian.author.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateBookDto(
                         @NotNull Long id,
                         @NotBlank String title,
                         @NotBlank String isbn,
                         @NotNull int quantityTotal,
                         @NotNull int quantityAvailable,
                         @NotBlank Genre genre
                         ) {
}
