package br.com.bibliteca.domian.dto.Loan;

import jakarta.validation.constraints.NotNull;

public record LoanDto(@NotNull(message = "O ID do livro é obrigatório")
                       Long userID,
                      @NotNull(message = "O ID do usuário é obrigatório")
                      Long bookId) {
}
