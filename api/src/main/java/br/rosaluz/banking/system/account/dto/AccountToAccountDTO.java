package br.rosaluz.banking.system.account.dto;


import br.rosaluz.banking.system.account.model.Account;
import org.springframework.core.convert.converter.Converter;


public class AccountToAccountDTO implements Converter<Account, AccountDTO> {

    @Override
    public AccountDTO convert(Account account) {

        return AccountDTO.builder()
                .accountNumber(account.getAccountNumber())
                .accountDigit(account.getAccountDigit())
                .agencyCode(account.getAgencyCode())
                .balance(account.getBalance())
                .userId(account.getUserId())
                .build();
    }
}
