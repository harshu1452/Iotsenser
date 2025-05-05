package turing.example.iotsenser.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Entity representing IoT sensor data.
 * Stores device readings such as temperature, humidity, and timestamp.
 */
@Entity
@Table(name = "sensor_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SensorData {

    /**
     * Unique identifier for each sensor data record.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Unique identifier for the IoT device sending the data.
     */
    @Column(nullable = false)
    private String deviceId;

    /**
     * Temperature reading from the IoT sensor.
     */
    @Column(nullable = false)
    private double temperature;

    /**
     * Humidity reading from the IoT sensor.
     */
    @Column(nullable = false)
    private double humidity;

    /**
     * Timestamp indicating when the sensor data was recorded.
     */
    @Column(nullable = false)
    private LocalDateTime timestamp;
}
