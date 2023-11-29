package SM1MSCGroup12.Subscriber.Kafka;

import SM1MSCGroup12.Subscriber.Controller.Repository;
import SM1MSCGroup12.Subscriber.Model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @Autowired
    Repository repository;


    @KafkaListener(topics = "${kafka.topic.sensor}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(Sensor s) {
        System.out.println("data : " + s.getSensorData() + " sensorID " + s.getSensorID() + " timestamp: " + s.getTimestamp());

        repository.save(s);




    }


}