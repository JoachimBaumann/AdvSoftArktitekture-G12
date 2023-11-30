package SM1MSCGroup12.Subscriber.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column(name = "sensorID")
    private String sensorID;

    @Column(name = "sensorData")
    private String sensorData;

    @Column(name = "timestamp")
    private String timestamp;

    @CreationTimestamp
    @Column(name = "created_At")
    private Timestamp created_At;

    public Timestamp getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Timestamp created_At) {
        this.created_At = created_At;
    }

    public Sensor(String sensorID, String sensorData, String timestamp) {
        this.sensorID = sensorID;
        this.sensorData = sensorData;
        this.timestamp = timestamp;
    }

    public Sensor(String sensorData, String timestamp) {
        this.sensorData = sensorData;
        this.timestamp = timestamp;
    }

    public String getSensorID() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }

    public String getSensorData() {
        return sensorData;
    }

    public void setSensorData(String sensorData) {
        this.sensorData = sensorData;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
