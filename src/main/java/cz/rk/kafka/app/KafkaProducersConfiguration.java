package cz.rk.kafka.app;

import cz.rk.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Kafka producer configuration
 */
@Configuration
public class KafkaProducersConfiguration {

    @Bean(name = "kafka-producer-topic-input")
    public KafkaProducer createKafkaProducerInputTopic(@Value("${kafka.producer.topic-input}") String topic) {
        return new KafkaProducer(topic);
    }


    @Bean(name = "kafka-producer-topic-output")
    public KafkaProducer createKafkaProducerOutputTopic(@Value("${kafka.producer.topic-output}") String topic) {
        return new KafkaProducer(topic);
    }

}
