package turing.example.iotsenser.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Entity representing an anomaly detected in IoT sensor data.
 * Stores information about unusual sensor readings.
 */
@Entity
@Table(name = "anomalies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Anomaly {

    /**
     * Unique identifier for each detected anomaly.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Reference to the device that generated the anomalous reading.
     */
    @Column(nullable = false)
    private String deviceId;

    /**
     * Temperature reading that triggered the anomaly.
     */
    @Column(nullable = false)
    private double temperature;

    /**
     * Humidity reading that triggered the anomaly.
     */
    @Column(nullable = false)
    private double humidity;

    /**
     * Timestamp when the anomaly was detected.
     */
    @Column(nullable = false)
    private LocalDateTime detectedAt;

    /**
     * Description of the anomaly, explaining why it was flagged.
     */
    @Column(nullable = false, length = 500)
    private String description;
}
