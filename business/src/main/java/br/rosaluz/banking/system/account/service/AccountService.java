package br.rosaluz.banking.system.account.service;

import br.rosaluz.banking.system.account.model.Account;

import java.util.Optional;

public interface AccountService {
    public Account save(Account account);
    public Account generateAccount();
    public Optional<Account> findByAccount(String accountNumber);
    public  Double getBalance(String accountNumber);
}
