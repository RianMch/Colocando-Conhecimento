package br.com.bibliteca.domian.repository;

import br.com.bibliteca.domian.role.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUser extends JpaRepository<User,Long> {
}
