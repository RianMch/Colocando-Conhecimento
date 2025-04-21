package br.com.bibliteca.domian.repository;

import br.com.bibliteca.domian.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAuthor extends JpaRepository<Author,Long> {
}
