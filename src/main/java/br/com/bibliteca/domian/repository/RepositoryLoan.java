package br.com.bibliteca.domian.repository;

import br.com.bibliteca.domian.role.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryLoan extends JpaRepository<Loan,Long> {
}
