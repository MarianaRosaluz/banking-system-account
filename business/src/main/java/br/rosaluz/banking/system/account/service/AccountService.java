package br.rosaluz.banking.system.account.service;

import br.rosaluz.banking.system.account.model.Account;
import br.rosaluz.banking.system.account.model.Consumer;

import java.util.Optional;

public interface AccountService {
    Account save(Account account);
    Account generateAccount(String userId);
    Optional<Account> findByAccount(String accountNumber);
    Double getBalance(String accountNumber);
}
