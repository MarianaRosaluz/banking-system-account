package br.rosaluz.banking.system.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private String agencyCode;
    private  String accountNumber;
    private  String accountDigit;
    private  double balance;

}
