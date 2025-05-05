package turing.example.iotsenser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main entry point for the IoT Sensor Application.
 * This class initializes and starts the Spring Boot application.
 */
@SpringBootApplication(exclude = io.opentelemetry.instrumentation.spring.autoconfigure.instrumentation.webmvc.SpringWebMvc6InstrumentationAutoConfiguration.class)
@EnableJpaRepositories("turing.example.iotsenser.repository")
public class IotSensorApplication {

    /**
     * The main method that starts the Spring Boot application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(IotSensorApplication.class, args);
    }
}
