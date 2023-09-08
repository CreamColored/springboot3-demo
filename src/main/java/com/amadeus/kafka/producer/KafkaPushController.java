package com.amadeus.kafka.producer;

import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONObject;
import com.amadeus.enums.KafkaTopicConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@RequestMapping("/kafka/push")
public class KafkaPushController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping(value = "/sendMsg")
    public String sendMsg(@RequestBody JSONObject jsonObject) {
        String topic = KafkaTopicConstant.TEST_TOPIC;
        String msg = jsonObject.get("message").toString();
        log.info("==========发送消息==========");
        CompletableFuture<SendResult<String, String>> completableFuture = kafkaTemplate.send(topic, UUID.fastUUID().toString(), msg);
        completableFuture.thenAccept(result -> {
            log.info("message send success:{}", msg);
        });
        completableFuture.exceptionally(e -> {
            log.error("message send failed:{}, error:{}", msg, e.getMessage());
            return null;
        });
        return "发送成功";
    }

}
