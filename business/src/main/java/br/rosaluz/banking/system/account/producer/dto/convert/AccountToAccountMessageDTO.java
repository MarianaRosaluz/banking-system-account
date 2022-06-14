package br.rosaluz.banking.system.account.producer.dto.convert;

import br.rosaluz.banking.system.account.model.Account;

public class AccountToAccountMessageDTO {
    public static AccountMessageDTO convert(Account account){

        return  AccountMessageDTO.builder().id(account.getId().toString()).build();

    }
}
