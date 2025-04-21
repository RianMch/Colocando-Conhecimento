package br.com.bibliteca.domian.repository;

import br.com.bibliteca.domian.role.Administrator;
import br.com.bibliteca.domian.role.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAdmin extends JpaRepository<Administrator,Long> {
}
