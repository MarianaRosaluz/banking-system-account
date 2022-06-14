package br.rosaluz.banking.system.account.consumer;

import br.rosaluz.banking.system.account.consumer.dto.UserConsumerMessageDTO;
import br.rosaluz.banking.system.account.consumer.dto.converter.UserConsumerMessageDTOToConsumer;
import br.rosaluz.banking.system.account.service.AccountService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    private static final Logger log = LoggerFactory.getLogger(UserConsumer.class);

    @Autowired
    private AccountService accountService;

    @Value(value = "${topic.consumer.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.consumer.name}", groupId = "${spring.kafka.group-id}", containerFactory = "transferKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, UserConsumerMessageDTO> record){
        accountService.generateAccount(record.value().getId().toString());
        log.info("Received Message " + record.partition());
        log.info("Received Message " + record.value());

    }
}
