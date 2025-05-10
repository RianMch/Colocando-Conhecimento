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
public class Loan<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;

    @Column(name = "ativo")
    private boolean ativo = true;

    // Construtor para criação de um novo empréstimo
    public Loan(User user, Book book) {
        this.user = user;
        this.book = book;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = this.dataEmprestimo.plusDays(7); // exemplo: 7 dias para devolução
        this.ativo = true;
        this.book.reduzirQuantidadeDisponivel(); // lógica no Book
    }

    // Marcar empréstimo como finalizado
    public void finalizar() {
        this.ativo = false;
        this.dataDevolucaoReal = LocalDate.now();
        this.book.aumentarQuantidadeDisponivel(); // lógica no Book
    }

    // Getters para campos customizados
    public LocalDate getReturnDate() {
        return dataDevolucaoPrevista;
    }

    public LocalDate getLoanDate() {
        return dataEmprestimo;
    }
}
