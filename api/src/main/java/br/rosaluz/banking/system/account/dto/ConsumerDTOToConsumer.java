package br.rosaluz.banking.system.account.dto;

import br.rosaluz.banking.system.account.model.Account;
import br.rosaluz.banking.system.account.model.Consumer;
import org.springframework.core.convert.converter.Converter;

public class ConsumerDTOToConsumer implements Converter<ConsumerDTO, Consumer> {

    @Override
    public Consumer convert(ConsumerDTO consumerDTO) {

        return Consumer.builder()
                .id(consumerDTO.getId())
                .name(consumerDTO.getName())
                .motherName(consumerDTO.getMotherName())
                .birthDate(consumerDTO.getBirthDate())
                .document(consumerDTO.getDocument())
                .build();
    }
}
