package br.com.bibliteca.domian.role;

import br.com.bibliteca.domian.author.Book;
import br.com.bibliteca.domian.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "loan")
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserBook user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;

    @Column(name = "ativo")
    private boolean ativo = true;
    public Loan(UserBook userBook, Book book) {
        this.user = userBook;
        this.book = book;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = this.dataEmprestimo.plusDays(7); // exemplo: 7 dias para devolução
        this.ativo = true;
        this.book.reduzirEstoque(); // lógica no Book
    }
    public void finalizar() {
        this.ativo = false;
        this.dataDevolucaoReal = LocalDate.now();
        this.book.aumentarQuantidade(); // lógica no Book
    }



}
