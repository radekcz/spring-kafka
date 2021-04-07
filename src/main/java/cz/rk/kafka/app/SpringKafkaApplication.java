package cz.rk.kafka.app;

import cz.rk.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"cz.rk.kafka.controller", "cz.rk.kafka.app", "cz.rk.kafka.producer", "cz.rk.kafka.consumer"})
public class SpringKafkaApplication implements ApplicationRunner {

    final private KafkaProducer kafkaProducerDefault;
    final private KafkaProducer kafkaProducerInputTopic;


    /**
     * constructor
     * @param kafkaProducerDefault
     * @param kafkaProducerInputTopic
     */
    public SpringKafkaApplication(KafkaProducer kafkaProducerDefault, @Qualifier("kafka-producer-topic-input") KafkaProducer kafkaProducerInputTopic) {
        this.kafkaProducerDefault = kafkaProducerDefault;
        this.kafkaProducerInputTopic = kafkaProducerInputTopic;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        kafkaProducerDefault.sendMessage("Default message from Spring Kafka application");
        kafkaProducerInputTopic.sendMessage("Input topic message from Spring Kafka application");
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaApplication.class, args);
    }

}
