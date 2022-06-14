package br.rosaluz.banking.system.account.exception;

import org.springframework.http.HttpStatus;

public class InsufficientBalanceForTransactionException extends BankingSystemAuthenticationException {

    public InsufficientBalanceForTransactionException(String message, String field){
        super(message, field, HttpStatus.PRECONDITION_FAILED);
    }
}
