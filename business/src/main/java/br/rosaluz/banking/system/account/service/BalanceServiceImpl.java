package br.rosaluz.banking.system.account.service;

import br.rosaluz.banking.system.account.exception.InsufficientBalanceForTransactionException;
import br.rosaluz.banking.system.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {
    @Autowired
    private AccountService accountService;

    @Override
    public void increaseBalance(String accountNumber, double amount) {

        Account account = accountService.findByAccount(accountNumber).get();
        account.setBalance(account.getBalance() + amount);
        accountService.save(account);

    }

    @Override
    public void decreaseBalance(String accountNumber, double amount) {
        Account account = accountService.findByAccount(accountNumber).get();
        if(!validAccountBalance(account,amount)) {
           throw new InsufficientBalanceForTransactionException("saldo insuficiente para realizar a transaçao", "amount");
        }
        account.setBalance(account.getBalance() - amount);
        accountService.save(account);
    }

    @Override
    public Double getBalance(String accountNumber) {
        Account account = accountService.findByAccount(accountNumber).get();

        return account.getBalance();
    }

    private Boolean validAccountBalance(Account account, double amount) {
        if(account.getBalance() < amount) {
            return false;
        }
        return true;
    }
}
