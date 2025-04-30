package br.com.bibliteca.domian.dto.author;

import br.com.bibliteca.domian.author.Genre;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateAuthorDto(@NotNull Long id,
                              String name,
                              String nationality,
                              LocalDate DateOfBirth,
                              Genre genre) {
}
