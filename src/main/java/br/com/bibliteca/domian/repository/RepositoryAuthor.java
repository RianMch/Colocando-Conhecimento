package br.com.bibliteca.domian.repository;

import br.com.bibliteca.domian.author.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;

public interface RepositoryAuthor extends JpaRepository<Author,Long> {
    Page<Author>findByAtivoTrue(Pageable pageable);
}
