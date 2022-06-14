package br.rosaluz.banking.system.account.service;


import br.rosaluz.banking.system.account.model.Account;
import br.rosaluz.banking.system.account.model.Consumer;
import br.rosaluz.banking.system.account.producer.AccountProducer;
import br.rosaluz.banking.system.account.producer.dto.convert.AccountMessageDTO;
import br.rosaluz.banking.system.account.repository.AccountRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountProducer accountProducer;


    public AccountServiceImpl(AccountRepository accountRepository, AccountProducer accountProducer) {
        this.accountRepository = accountRepository;
        this.accountProducer = accountProducer;
    }

    @Override
    public Account save(Account account){
        return  accountRepository.save(account);
    }

    @Override
    public Account generateAccount(String userId){
        var account = Account.builder()
                .accountDigit("0")
                .accountNumber(generateAccountNumber())
                .agencyCode("0001")
                .balance(0)
                .userId(userId)
                .build();


       return save(account);
    }
    @Override
    public Optional<Account> findByAccount(String accountNumber){

        var accountOptional = accountRepository.findByaccountNumber(accountNumber);
        if(!accountOptional.isPresent())
            return null;

        return accountOptional;
    }

    private String generateAccountNumber(){
        Random generator = new Random();
        var account =  (long) generator.nextInt(100000);
        return Long.toString(account) ;
    }
    @Override
    public Double getBalance(String accountNumber){

        Optional<Account> account = accountRepository.findByaccountNumber(accountNumber);

        return account.get().getBalance();
    }
}
