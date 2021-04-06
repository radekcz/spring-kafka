package cz.rk.kafka.controller;

import cz.rk.kafka.producer.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.IntStream;

/**
 * Publish controller
 */
@RestController
public class PublishController {

    private KafkaProducer kafkaProducer;


    public PublishController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    @GetMapping("/publish/{count}")
    public String publish(@PathVariable int count) {
        // publish "count" messages
        IntStream.range(0, count).forEach(i -> kafkaProducer.sendMessage("Message no.: " + i));
        return "Publishing done.";
    }

}
