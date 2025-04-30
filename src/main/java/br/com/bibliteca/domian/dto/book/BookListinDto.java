package br.com.bibliteca.domian.dto.book;

import br.com.bibliteca.domian.author.Author;
import br.com.bibliteca.domian.author.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookListinDto(Long id, String title,
                            String isbn,
                            int quantityTotal,
                            int quantityAvailable,
                            Genre genre,
                            Author author) {
}
