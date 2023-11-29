package SM1MSCGroup12.Subscriber.Model;

import SM1MSCGroup12.Subscriber.Model.Sensor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class SensorSerializer implements Serializer<Sensor> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No additional configuration needed
    }

    @Override
    public byte[] serialize(String topic, Sensor data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing Sensor to byte[]: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        // No resources to release
    }
}
