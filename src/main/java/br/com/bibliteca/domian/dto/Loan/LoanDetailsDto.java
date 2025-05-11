package br.com.bibliteca.domian.dto.Loan;

import br.com.bibliteca.domian.role.Loan;

import java.time.LocalDate;

public record LoanDetailsDto(
        Long id,
        String userName,
        String bookTitle,
        LocalDate loanDate,
        LocalDate returnDate
) {
    public LoanDetailsDto(Loan loan) {
        this(
                loan.getId(),
                loan.getUser().getName()                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  ,
                loan.getBook().getTitle(),
                loan.getDataEmprestimo(),
                loan.getDataDevolucaoReal()
        );

    }
}
