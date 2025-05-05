package turing.example.iotsenser.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the Anomaly entity.
 * Ensures that all fields are correctly set and retrieved.
 */
class AnomalyTest {

    /**
     * Test case to verify that the Anomaly entity is correctly instantiated
     * using setters and retrieved properly with getters.
     */
    @Test
    void testAnomalyEntity() {
        // Given: Sample anomaly details
        Long id = 1L;
        String deviceId = "device123";
        double temperature = 75.5;
        double humidity = 30.2;
        LocalDateTime detectedAt = LocalDateTime.now();
        String description = "Temperature exceeded the normal threshold.";

        // When: Creating a new Anomaly instance
        Anomaly anomaly = new Anomaly();
        anomaly.setId(id);
        anomaly.setDeviceId(deviceId);
        anomaly.setTemperature(temperature);
        anomaly.setHumidity(humidity);
        anomaly.setDetectedAt(detectedAt);
        anomaly.setDescription(description);

        // Then: Ensure the values are correctly stored and retrieved
        assertEquals(id, anomaly.getId(), "ID should match the expected value.");
        assertEquals(deviceId, anomaly.getDeviceId(), "Device ID should match the expected value.");
        assertEquals(temperature, anomaly.getTemperature(), "Temperature should match the expected value.");
        assertEquals(humidity, anomaly.getHumidity(), "Humidity should match the expected value.");
        assertEquals(detectedAt, anomaly.getDetectedAt(), "Detected timestamp should match the expected value.");
        assertEquals(description, anomaly.getDescription(), "Description should match the expected value.");
    }

    /**
     * Test case to verify the parameterized constructor works as expected.
     */
    @Test
    void testAnomalyParameterizedConstructor() {
        // Given: Sample anomaly details
        Long id = 2L;
        String deviceId = "device456";
        double temperature = 60.3;
        double humidity = 40.1;
        LocalDateTime detectedAt = LocalDateTime.now();
        String description = "Humidity dropped below the normal range.";

        // When: Using the all-args constructor
        Anomaly anomaly = new Anomaly(id, deviceId, temperature, humidity, detectedAt, description);

        // Then: Ensure all fields are properly initialized
        assertNotNull(anomaly, "Anomaly object should not be null.");
        assertEquals(id, anomaly.getId(), "ID should match the expected value.");
        assertEquals(deviceId, anomaly.getDeviceId(), "Device ID should match the expected value.");
        assertEquals(temperature, anomaly.getTemperature(), "Temperature should match the expected value.");
        assertEquals(humidity, anomaly.getHumidity(), "Humidity should match the expected value.");
        assertEquals(detectedAt, anomaly.getDetectedAt(), "Detected timestamp should match the expected value.");
        assertEquals(description, anomaly.getDescription(), "Description should match the expected value.");
    }

    /**
     * Test case to verify the toString() method generates the expected string format.
     */
    @Test
    void testToStringMethod() {
        // Given: Sample anomaly
        Anomaly anomaly = new Anomaly(3L, "device789", 80.1, 25.5, LocalDateTime.now(), "Extreme temperature detected");

        // When: Calling toString()
        String anomalyString = anomaly.toString();

        // Then: Ensure the generated string contains key details
        assertTrue(anomalyString.contains("device789"), "String representation should include the device ID.");
        assertTrue(anomalyString.contains("80.1"), "String representation should include the temperature.");
        assertTrue(anomalyString.contains("25.5"), "String representation should include the humidity.");
        assertTrue(anomalyString.contains("Extreme temperature detected"), "String representation should include the description.");
    }
}
