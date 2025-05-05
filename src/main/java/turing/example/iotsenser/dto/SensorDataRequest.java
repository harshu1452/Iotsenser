package turing.example.iotsenser.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for receiving IoT sensor data requests.
 * Ensures validation before processing the request.
 */
@Getter
@Setter
public class SensorDataRequest {

    /**
     * Unique identifier of the IoT device sending the data.
     * Must not be blank.
     */
    @NotBlank(message = "Device ID cannot be empty")
    private String deviceId;

    /**
     * Temperature reading from the IoT sensor.
     * Must be a positive value.
     */
    @NotNull(message = "Temperature is required")
    @Positive(message = "Temperature must be greater than zero")
    private Double temperature;

    /**
     * Humidity reading from the IoT sensor.
     * Must be a positive value.
     */
    @NotNull(message = "Humidity is required")
    @Positive(message = "Humidity must be greater than zero")
    private Double humidity;

    /**
     * Timestamp indicating when the sensor data was recorded.
     * Defaults to the current time if not provided.
     */
    private LocalDateTime timestamp = LocalDateTime.now();
}
