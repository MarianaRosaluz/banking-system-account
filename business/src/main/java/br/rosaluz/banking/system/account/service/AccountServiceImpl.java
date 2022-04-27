package br.rosaluz.banking.system.account.service;


import br.rosaluz.banking.system.account.model.Account;
import br.rosaluz.banking.system.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account){
        return  accountRepository.save(account);
    }

    @Override
    public Account generateAccount(){
        Account account = new Account((long) 0001, generateAccountNumber(),generateAccountNumber(),0);
        save(account);
        return  account;
    }
    @Override
    public Optional<Account> findByaccountNumber(Long accountNumber){
        return accountRepository.findByaccountNumber(accountNumber);
    }

    private Long generateAccountNumber(){
        Random generator = new Random();
        return (long) generator.nextInt(100000);
    }
    @Override
    public Double getBalance(Long accountNumber){

        Optional<Account> account = accountRepository.findByaccountNumber(accountNumber);

        return account.get().getBalance();
    }
}
