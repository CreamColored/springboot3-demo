package com.amadeus.kafka.consumer;

import com.amadeus.enums.KafkaTopicConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaListenConsumer {

    @KafkaListener(topics = KafkaTopicConstant.TEST_TOPIC)
    public void test(String message, Acknowledgment ack) {
        log.info("==========接收来自test-topic的消息==========");
        try {
            log.info("message content:{}", message);
            System.out.println(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ack.acknowledge();
        }
    }
}
