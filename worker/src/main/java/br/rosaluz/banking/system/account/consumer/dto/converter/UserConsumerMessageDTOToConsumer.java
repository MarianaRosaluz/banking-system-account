package br.rosaluz.banking.system.account.consumer.dto.converter;

import br.rosaluz.banking.system.account.consumer.dto.UserConsumerMessageDTO;
import br.rosaluz.banking.system.account.model.Consumer;

public class UserConsumerMessageDTOToConsumer {

    public static Consumer converter(UserConsumerMessageDTO userConsumerMessageDTO){
        return Consumer.builder()
                .id(userConsumerMessageDTO.getId())
                .document(userConsumerMessageDTO.getDocument())
                .name(userConsumerMessageDTO.getName())
                .build();

    }
}
