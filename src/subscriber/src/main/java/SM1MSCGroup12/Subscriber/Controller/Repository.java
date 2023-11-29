package SM1MSCGroup12.Subscriber.Controller;

import SM1MSCGroup12.Subscriber.Model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Sensor, String> {


}