package turing.example.iotsenser.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import turing.example.iotsenser.model.SensorData;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for AnomalyDetectionService.
 * Ensures correct behavior for anomaly detection logic.
 */
@ExtendWith(MockitoExtension.class)
class AnomalyDetectionServiceTest {

    @Mock
    private SensorDataService sensorDataService;

    @InjectMocks
    private AnomalyDetectionService anomalyDetectionService;

    private SensorData normalData;
    private SensorData highTempData;
    private SensorData highHumidityData;
    private SensorData extremeAnomaly;

    /**
     * Setup test data before each test case runs.
     */
    @BeforeEach
    void setUp() {
        normalData = new SensorData(1L, "device123", 25.0, 60.0, LocalDateTime.now());
        highTempData = new SensorData(2L, "device456", 85.0, 55.0, LocalDateTime.now());
        highHumidityData = new SensorData(3L, "device789", 50.0, 95.0, LocalDateTime.now());
        extremeAnomaly = new SensorData(4L, "device999", 90.0, 98.0, LocalDateTime.now());
    }

    /**
     * Test case to verify that detectAnomalies() correctly filters out normal data.
     */
    @Test
    void testDetectAnomalies() {
        // Given: A list of sensor data with some anomalies
        List<SensorData> allData = List.of(normalData, highTempData, highHumidityData, extremeAnomaly);
        when(sensorDataService.getAllSensorData()).thenReturn(allData);

        // When: Detecting anomalies
        List<SensorData> anomalies = anomalyDetectionService.detectAnomalies();

        // Then: Ensure correct anomalies are identified
        assertEquals(3, anomalies.size(), "Should detect exactly 3 anomalies.");
        assertTrue(anomalies.contains(highTempData), "High temperature should be detected as anomaly.");
        assertTrue(anomalies.contains(highHumidityData), "High humidity should be detected as anomaly.");
        assertTrue(anomalies.contains(extremeAnomaly), "Extreme anomaly should be detected.");
        assertFalse(anomalies.contains(normalData), "Normal data should not be flagged as anomaly.");

        // Verify interaction with mock service
        verify(sensorDataService, times(1)).getAllSensorData();
    }

    /**
     * Test case to verify that isAnomalous() correctly detects anomalies.
     */
    @Test
    void testIsAnomalous() {
        // When & Then: Checking individual records
        assertFalse(anomalyDetectionService.isAnomalous(normalData), "Normal data should not be anomalous.");
        assertTrue(anomalyDetectionService.isAnomalous(highTempData), "High temperature data should be anomalous.");
        assertTrue(anomalyDetectionService.isAnomalous(highHumidityData), "High humidity data should be anomalous.");
        assertTrue(anomalyDetectionService.isAnomalous(extremeAnomaly), "Extreme anomaly should be detected.");
    }
}
