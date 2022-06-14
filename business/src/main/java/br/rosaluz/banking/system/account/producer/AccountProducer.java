package br.rosaluz.banking.system.account.producer;

import br.rosaluz.banking.system.account.model.Account;
import br.rosaluz.banking.system.account.producer.dto.convert.AccountMessageDTO;
import br.rosaluz.banking.system.account.producer.dto.convert.AccountToAccountMessageDTO;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountProducer {

    private static final Logger logger = LoggerFactory.getLogger(AccountProducer.class);
    private final String topic;
    private final KafkaTemplate<String, AccountMessageDTO> kafkaTemplate;

    public AccountProducer(@Value("${topic.name}") String topic, KafkaTemplate<String, AccountMessageDTO> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Account account){
        var accountMessageDTO = AccountToAccountMessageDTO.convert(account);
        kafkaTemplate.send(topic, accountMessageDTO).addCallback(
                success -> logger.info("Messagem send" + success.getProducerRecord().value()),
                failure -> logger.info("Message failure" + failure.getMessage())
        );
    }
}
