package turing.example.iotsenser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turing.example.iotsenser.model.SensorData;

import java.util.List;

/**
 * Service for detecting anomalies in IoT sensor data.
 * Uses basic threshold-based anomaly detection logic.
 */
@Service
public class AnomalyDetectionService {

    private static final double TEMPERATURE_THRESHOLD = 80.0;
    private static final double HUMIDITY_THRESHOLD = 90.0;

    private final SensorDataService sensorDataService;

    /**
     * Constructor-based dependency injection for SensorDataService.
     *
     * @param sensorDataService Service for retrieving sensor data.
     */
    @Autowired
    public AnomalyDetectionService(SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }

    /**
     * Detects anomalies in the most recent sensor data.
     * An anomaly is identified if the temperature or humidity exceeds predefined thresholds.
     *
     * @return List of SensorData records that are considered anomalies.
     */
    public List<SensorData> detectAnomalies() {
        List<SensorData> recentData = sensorDataService.getAllSensorData();
        return recentData.stream()
                .filter(data -> data.getTemperature() > TEMPERATURE_THRESHOLD || data.getHumidity() > HUMIDITY_THRESHOLD)
                .toList();
    }

    /**
     * Checks if a specific sensor data record contains an anomaly.
     *
     * @param sensorData The sensor data record to be evaluated.
     * @return `true` if an anomaly is detected, otherwise `false`.
     */
    public boolean isAnomalous(SensorData sensorData) {
        return sensorData.getTemperature() > TEMPERATURE_THRESHOLD || sensorData.getHumidity() > HUMIDITY_THRESHOLD;
    }
}
