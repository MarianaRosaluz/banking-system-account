package br.rosaluz.banking.system.account.handler;



import br.rosaluz.banking.system.account.exception.BankingSystemAuthenticationException;
import br.rosaluz.banking.system.account.handler.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({BankingSystemAuthenticationException.class})
    public ResponseEntity<?> handleBankingSystemAuthenticationException(final BankingSystemAuthenticationException bankingSystemAuthenticationException) {
        return ResponseEntity.status(bankingSystemAuthenticationException.getStatus()).body(
                ErrorResponse.builder()
                        .codeStatus(bankingSystemAuthenticationException.getStatus().value())
                        .field(bankingSystemAuthenticationException.getFieldError())
                        .description(bankingSystemAuthenticationException.getMessage())
                        .build()
        );
    }
}
