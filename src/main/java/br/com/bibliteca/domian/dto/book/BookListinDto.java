package br.com.bibliteca.domian.dto.book;

import br.com.bibliteca.domian.author.Author;
import br.com.bibliteca.domian.author.Book;
import br.com.bibliteca.domian.author.Genre;
import br.com.bibliteca.domian.dto.author.AuthorBasicDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookListinDto(Long id, String title,
                            String isbn,
                            int quantityTotal,
                            int quantityAvailable,
                            Genre genre,
                            AuthorBasicDto author) {
    public BookListinDto(Book book){
        this(book.getId(), book.getTitle(), book.getIsbn(), book.getQuantityTotal(), book.getQuantityAvailable(), book.getGenre(),new AuthorBasicDto(book.getAuthor()));
    }
}
