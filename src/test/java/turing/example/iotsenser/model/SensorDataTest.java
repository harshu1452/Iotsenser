package turing.example.iotsenser.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the SensorData entity.
 * Ensures all fields are correctly set and retrieved.
 */
class SensorDataTest {

    /**
     * Test case to verify that the SensorData entity is correctly instantiated
     * using setters and retrieved properly with getters.
     */
    @Test
    void testSensorDataEntity() {
        // Given: Sample sensor data
        Long id = 1L;
        String deviceId = "device123";
        double temperature = 22.5;
        double humidity = 55.3;
        LocalDateTime timestamp = LocalDateTime.now();

        // When: Creating a new SensorData instance
        SensorData sensorData = new SensorData();
        sensorData.setId(id);
        sensorData.setDeviceId(deviceId);
        sensorData.setTemperature(temperature);
        sensorData.setHumidity(humidity);
        sensorData.setTimestamp(timestamp);

        // Then: Ensure the values are correctly stored and retrieved
        assertEquals(id, sensorData.getId(), "ID should match the expected value.");
        assertEquals(deviceId, sensorData.getDeviceId(), "Device ID should match the expected value.");
        assertEquals(temperature, sensorData.getTemperature(), "Temperature should match the expected value.");
        assertEquals(humidity, sensorData.getHumidity(), "Humidity should match the expected value.");
        assertEquals(timestamp, sensorData.getTimestamp(), "Timestamp should match the expected value.");
    }

    /**
     * Test case to verify the parameterized constructor works as expected.
     */
    @Test
    void testSensorDataParameterizedConstructor() {
        // Given: Sample sensor data
        Long id = 2L;
        String deviceId = "device456";
        double temperature = 18.7;
        double humidity = 60.2;
        LocalDateTime timestamp = LocalDateTime.now();

        // When: Using the all-args constructor
        SensorData sensorData = new SensorData(id, deviceId, temperature, humidity, timestamp);

        // Then: Ensure all fields are properly initialized
        assertNotNull(sensorData, "SensorData object should not be null.");
        assertEquals(id, sensorData.getId(), "ID should match the expected value.");
        assertEquals(deviceId, sensorData.getDeviceId(), "Device ID should match the expected value.");
        assertEquals(temperature, sensorData.getTemperature(), "Temperature should match the expected value.");
        assertEquals(humidity, sensorData.getHumidity(), "Humidity should match the expected value.");
        assertEquals(timestamp, sensorData.getTimestamp(), "Timestamp should match the expected value.");
    }

    /**
     * Test case to verify the toString() method generates the expected string format.
     */
    @Test
    void testToStringMethod() {
        // Given: Sample sensor data
        SensorData sensorData = new SensorData(3L, "device789", 25.1, 70.4, LocalDateTime.now());

        // When: Calling toString()
        String sensorDataString = sensorData.toString();

        // Then: Ensure the generated string contains key details
        assertTrue(sensorDataString.contains("device789"), "String representation should include the device ID.");
        assertTrue(sensorDataString.contains("25.1"), "String representation should include the temperature.");
        assertTrue(sensorDataString.contains("70.4"), "String representation should include the humidity.");
    }
}
