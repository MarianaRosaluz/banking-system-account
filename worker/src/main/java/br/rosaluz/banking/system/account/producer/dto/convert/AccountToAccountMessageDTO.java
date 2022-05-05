package br.rosaluz.banking.system.account.producer.dto.convert;

import br.rosaluz.banking.system.account.model.Account;
import br.rosaluz.banking.system.account.producer.dto.AccountMessageDTO;

public class AccountToAccountMessageDTO {
    public static AccountMessageDTO convert(Account account){

        return  new AccountMessageDTO();

    }
}
