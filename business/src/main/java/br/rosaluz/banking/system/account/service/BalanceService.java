package br.rosaluz.banking.system.account.service;

public interface BalanceService {

    void increaseBalance(String accountNumber, double amount);
    void decreaseBalance(String accountNumber, double amount);

    public  Double getBalance(String accountNumber);
}
