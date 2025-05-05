package turing.example.iotsenser.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import turing.example.iotsenser.model.SensorData;
import turing.example.iotsenser.service.SensorDataService;

import java.util.List;

/**
 * Controller for handling IoT sensor data.
 * Provides REST endpoints for ingesting and retrieving sensor data.
 * Uses Kafka for real-time event streaming and a service layer for processing.
 */
@RestController
@RequestMapping("/api/sensors")
public class SensorDataController {

    private final SensorDataService sensorDataService;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String KAFKA_TOPIC = "sensor-data";

    /**
     * Constructor-based dependency injection.
     *
     * @param sensorDataService Service layer for sensor data processing.
     * @param kafkaTemplate     Kafka template for event publishing.
     */
    @Autowired
    public SensorDataController(SensorDataService sensorDataService, KafkaTemplate<String, String> kafkaTemplate) {
        this.sensorDataService = sensorDataService;
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Endpoint to ingest new sensor data.
     * The data is persisted in the database and sent to Kafka for real-time processing.
     *
     * @param sensorData The sensor data received from IoT devices.
     * @return ResponseEntity indicating success or failure.
     */
    @PostMapping("/ingest")
    public ResponseEntity<String> ingestSensorData(@RequestBody SensorData sensorData) {
        sensorDataService.saveSensorData(sensorData);

        // Send data to Kafka for real-time streaming
        kafkaTemplate.send(KAFKA_TOPIC, sensorData.toString());

        return ResponseEntity.ok("Sensor data ingested successfully.");
    }

    /**
     * Endpoint to retrieve all sensor data records.
     *
     * @return List of SensorData objects.
     */
    @GetMapping("/all")
    public ResponseEntity<List<SensorData>> getAllSensorData() {
        List<SensorData> sensorDataList = sensorDataService.getAllSensorData();
        return ResponseEntity.ok(sensorDataList);
    }

    /**
     * Endpoint to retrieve sensor data for a specific device.
     *
     * @param deviceId Unique identifier of the IoT device.
     * @return List of SensorData records filtered by deviceId.
     */
    @GetMapping("/{deviceId}")
    public ResponseEntity<List<SensorData>> getSensorDataByDevice(@PathVariable String deviceId) {
        List<SensorData> sensorDataList = sensorDataService.getSensorDataByDevice(deviceId);
        return ResponseEntity.ok(sensorDataList);
    }

    /**
     * Health check endpoint for monitoring purposes.
     *
     * @return A simple status message indicating service availability.
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Sensor Data Service is up and running.");
    }
}
