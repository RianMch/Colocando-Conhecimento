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
        this.quantityTotal = validarQuantidade(bookDto.quantityTotal());
        this.quantityAvailable = validarQuantidadeDisponivel(bookDto.quantityAvailable(), this.quantityTotal);
        this.genre = bookDto.genre();
        this.author = repositoryAuthor.getReferenceById(bookDto.authorID());
    }

    private int validarQuantidade(int quantidade) {
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser maior que 0.");
        return quantidade;
    }

    private int validarQuantidadeDisponivel(int disponivel, int total) {
        if (disponivel < 0 || disponivel > total) {
            throw new IllegalArgumentException("Quantidade disponível inválida.");
        }
        return disponivel;
    }

    public void update(@Valid UpdateBookDto updateBookDto) {
        if (updateBookDto.title() != null) this.title = updateBookDto.title();
        if (updateBookDto.quantityTotal() > 0) this.quantityTotal = updateBookDto.quantityTotal();
        if (updateBookDto.quantityAvailable() >= 0 && updateBookDto.quantityAvailable() <= this.quantityTotal) {
            this.quantityAvailable = updateBookDto.quantityAvailable();
        }
        if (updateBookDto.genre() != null) this.genre = updateBookDto.genre();
        if (updateBookDto.isbn() != null) this.isbn = updateBookDto.isbn();
    }

    public void delete(){
        this.ativo=false;
    }

    public void reduzirEstoque(){
        if(this.quantityTotal>0){
            this.quantityTotal--;
        }else{
            throw  new IllegalArgumentException("Não ha exemplares Disponíveis");
        }

    }



}
