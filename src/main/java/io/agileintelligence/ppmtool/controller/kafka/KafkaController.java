package io.agileintelligence.ppmtool.controller.kafka;

import io.agileintelligence.ppmtool.services.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/producer")
    public String sendMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessageToTopic(message);
        return "Message sent successfully to the topic.";
    }
}