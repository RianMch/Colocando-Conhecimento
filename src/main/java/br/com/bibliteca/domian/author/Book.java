package br.com.bibliteca.domian.author;

import br.com.bibliteca.domian.dto.author.AuthorDto;
import br.com.bibliteca.domian.dto.book.BookDto;
import br.com.bibliteca.domian.dto.book.UpdateBookDto;
import br.com.bibliteca.domian.repository.RepositoryAuthor;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book")
@Table(name = "books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String isbn;
    @NotNull
    private int quantityTotal;
    @NotNull
    private int quantityAvailable;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    private boolean ativo;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(@Valid BookDto bookDto, RepositoryAuthor repositoryAuthor) {
        this.ativo = true;
        this.title = bookDto.title();
        this.isbn = bookDto.isbn();
        this.quantityAvailable = bookDto.quantityAvailable();
        this.genre = bookDto.genre();
        this.quantityTotal = bookDto.quantityTotal();
        this.author = repositoryAuthor.getReferenceById(bookDto.authorID());

    }

    public void delete() {
        this.ativo = false;
    }

    public void verificacao() {
    }

    public void update(@Valid UpdateBookDto updateBookDtobook) {
        if (updateBookDtobook.title() != null) {
            this.title = updateBookDtobook.title();
        }
        if (updateBookDtobook.quantityAvailable() > 0) {
            this.quantityAvailable = updateBookDtobook.quantityAvailable();
        }
        if (updateBookDtobook.quantityTotal() > 0) {
            this.quantityTotal = updateBookDtobook.quantityTotal();
        }
        if (updateBookDtobook.genre() != null) {
            this.genre = updateBookDtobook.genre();
        }
        if (updateBookDtobook.isbn() != null) {
            this.isbn = updateBookDtobook.isbn();
        }
    }


}
