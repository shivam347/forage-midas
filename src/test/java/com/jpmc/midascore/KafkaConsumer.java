package com.jpmc.midascore;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.jpmc.midascore.foundation.Transaction;

@Component
public class KafkaConsumer {

    // The topic name is injected from the application properties file

    // This method listens to the Kafka topic and processes incoming transactions
    // The @KafkaListener annotation is used to specify the topic and group ID for
    // the consumer
    // The containerFactory is used to define how the messages are deserialized
    // The Transaction class is used to map the incoming messages to Java objects

   
    @KafkaListener(topics = "${general.kafka-topic}", groupId = "midas-core-group", containerFactory = "transactionKafkaListenerContainerFactory")
    public void listen(Transaction transactions) {
        // This method will be invoked for each transaction received from the Kafka
        // topic
        // You can implement your logic here to process the transaction
        System.out.println("Received transaction: " + transactions);
    }

}