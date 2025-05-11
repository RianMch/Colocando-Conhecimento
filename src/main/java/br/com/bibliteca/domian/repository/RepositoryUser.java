package br.com.bibliteca.domian.repository;

import br.com.bibliteca.domian.role.UserBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RepositoryUser extends JpaRepository<UserBook,Long> {
    Page<UserBook> findAllByAtivoTrue(Pageable pageable);
}
