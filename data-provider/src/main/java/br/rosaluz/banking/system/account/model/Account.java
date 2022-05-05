package br.rosaluz.banking.system.account.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String agencyCode;
    @NotNull @Column(unique=true)
    private  String accountNumber;
    @NotNull
    private  String accountDigit;
    private  double balance;



}
