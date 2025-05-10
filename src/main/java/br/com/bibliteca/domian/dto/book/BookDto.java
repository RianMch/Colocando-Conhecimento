package br.com.bibliteca.domian.dto.book;

import br.com.bibliteca.domian.author.Author;
import br.com.bibliteca.domian.author.Book;
import br.com.bibliteca.domian.author.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookDto(@NotBlank String title,
                      @NotBlank String isbn,
                      @NotNull int quantityTotal,
                      @NotNull int quantityAvailable,
                      @NotNull Genre genre,
                      @NotNull Long authorID) {
    public BookDto(Book book) {
        this(book.getTitle(), book.getIsbn(), book.getQuantityTotal(), book.getQuantityAvailable(), book.getGenre(),book.getAuthor().getId());
    }


}
