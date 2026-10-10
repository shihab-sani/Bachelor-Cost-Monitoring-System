package Bachelor.CostMonitoringSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BachelorCostMonitoringSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BachelorCostMonitoringSystemApplication.class, args);
    }

}
