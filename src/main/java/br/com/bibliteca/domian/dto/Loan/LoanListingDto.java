package br.com.bibliteca.domian.dto.Loan;

import br.com.bibliteca.domian.role.Loan;

import java.time.LocalDate;

public record LoanListingDto(Long UserId, Long BookId, LocalDate dataEmprestimo,LocalDate dataDevolucaoPrevista,LocalDate dataDevolucaoReal) {
    public LoanListingDto(Loan loan){
        this(loan.getUser().getId(), loan.getBook().getId(),loan.getDataEmprestimo(),loan.getDataDevolucaoPrevista(),loan.getDataDevolucaoReal());
    }
}
