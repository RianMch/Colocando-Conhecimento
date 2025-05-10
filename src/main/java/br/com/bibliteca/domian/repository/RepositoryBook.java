package br.com.bibliteca.domian.repository;

import br.com.bibliteca.domian.author.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBook extends JpaRepository<Book,Long> {
    Page<Book> findByAtivoTrue(Pageable pageable);
}
