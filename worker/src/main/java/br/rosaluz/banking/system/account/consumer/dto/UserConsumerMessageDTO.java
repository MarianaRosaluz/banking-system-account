package br.rosaluz.banking.system.account.consumer.dto;

import lombok.Data;

@Data
public class UserConsumerMessageDTO {

    private Long id;
    private  String name;
    private String document;
    private String birthDate;
    private String motherName;
    private  String login;
    private String  password;
}
