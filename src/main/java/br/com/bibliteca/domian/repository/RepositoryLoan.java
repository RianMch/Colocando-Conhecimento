package br.com.bibliteca.domian.repository;


import br.com.bibliteca.domian.role.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryLoan extends JpaRepository<Loan,Long> {

    Page<Loan> findByAtivoTrue(Pageable pageable);
}
