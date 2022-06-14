package br.rosaluz.banking.system.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerDTO {
    private Long id;
    private  String name;
    private String document;
    private String birthDate;
    private String motherName;
    private  String login;
    private String  password;
}
