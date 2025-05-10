package br.com.bibliteca.domian.dto.book;

import br.com.bibliteca.domian.author.Book;
import br.com.bibliteca.domian.author.Genre;
import br.com.bibliteca.domian.dto.author.AuthorBasicDto;
import br.com.bibliteca.domian.dto.author.AuthorDto;


public record BookDetailsDTO(Long id, String title, String isbn, int quantityTotal, int quantityAvailable, Genre genre,
                             AuthorBasicDto author) {
    public BookDetailsDTO(Book book) {
        this(book.getId(), book.getTitle(), book.getIsbn(), book.getQuantityTotal(), book.getQuantityAvailable(), book.getGenre(), new AuthorBasicDto(book.getAuthor()));
    }
}
