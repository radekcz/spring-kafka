package cz.rk.kafka.app;

import cz.rk.kafka.producer.KafkaProducer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"cz.rk.kafka.controller", "cz.rk.kafka.app", "cz.rk.kafka.producer", "cz.rk.kafka.consumer"})
public class SpringKafkaApplication implements ApplicationRunner {

    final private KafkaProducer kafkaProducer;


    /**
     * constructor
     *
     * we don't even need an @Autowired on our constructor
     * @param kafkaProducer
     */
    public SpringKafkaApplication(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        kafkaProducer.sendMessage("Message from Spring Kafka application");
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaApplication.class, args);
    }

}
