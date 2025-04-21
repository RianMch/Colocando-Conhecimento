package br.com.bibliteca.domian.repository;

import br.com.bibliteca.domian.role.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAdmin extends JpaRepository<Admin,Long> {
}
