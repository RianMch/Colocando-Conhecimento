package br.com.bibliteca.domian.repository;

import br.com.bibliteca.domian.author.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBook extends JpaRepository<Book,Long> {
}
