package SM1MSCGroup12.Subscriber.Controller;

import SM1MSCGroup12.Subscriber.Model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/")
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    Repository repository;

    @GetMapping("getall/")
    public List<Sensor> getSensorData() {
        return repository.findAll();
    }

}
