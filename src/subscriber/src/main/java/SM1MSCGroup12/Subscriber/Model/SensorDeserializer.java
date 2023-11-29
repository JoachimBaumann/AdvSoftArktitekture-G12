package SM1MSCGroup12.Subscriber.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class SensorDeserializer implements Deserializer<Sensor> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No additional configuration needed
    }

    @Override
    public Sensor deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, Sensor.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing byte[] to Sensor: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        // No resources to release
    }
}
