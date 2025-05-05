package turing.example.iotsenser.utils;

import org.junit.jupiter.api.Test;
import turing.example.iotsenser.dto.SensorDataRequest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for SensorDataValidator.
 * Ensures that sensor data validation logic functions correctly.
 */
class SensorDataValidatorTest {

    /**
     * Test case for valid sensor data.
     */
    @Test
    void testValidSensorData() {
        SensorDataRequest request = new SensorDataRequest();
        request.setTemperature(25.0);
        request.setHumidity(50.0);

        assertTrue(SensorDataValidator.isValid(request), "Valid sensor data should return true.");
    }

    /**
     * Test case for invalid temperature (too high).
     */
    @Test
    void testInvalidTemperatureTooHigh() {
        SensorDataRequest request = new SensorDataRequest();
        request.setTemperature(150.0); // Above max limit
        request.setHumidity(50.0);

        assertFalse(SensorDataValidator.isValid(request), "Temperature above max limit should return false.");
    }

    /**
     * Test case for invalid temperature (too low).
     */
    @Test
    void testInvalidTemperatureTooLow() {
        SensorDataRequest request = new SensorDataRequest();
        request.setTemperature(-60.0); // Below min limit
        request.setHumidity(50.0);

        assertFalse(SensorDataValidator.isValid(request), "Temperature below min limit should return false.");
    }

    /**
     * Test case for invalid humidity (too high).
     */
    @Test
    void testInvalidHumidityTooHigh() {
        SensorDataRequest request = new SensorDataRequest();
        request.setTemperature(25.0);
        request.setHumidity(110.0); // Above max limit

        assertFalse(SensorDataValidator.isValid(request), "Humidity above max limit should return false.");
    }

    /**
     * Test case for invalid humidity (too low).
     */
    @Test
    void testInvalidHumidityTooLow() {
        SensorDataRequest request = new SensorDataRequest();
        request.setTemperature(25.0);
        request.setHumidity(-5.0); // Below min limit

        assertFalse(SensorDataValidator.isValid(request), "Humidity below min limit should return false.");
    }

    /**
     * Test case for null temperature.
     */
    @Test
    void testNullTemperature() {
        SensorDataRequest request = new SensorDataRequest();
        request.setTemperature(null);
        request.setHumidity(50.0);

        assertFalse(SensorDataValidator.isValid(request), "Null temperature should return false.");
    }

    /**
     * Test case for null humidity.
     */
    @Test
    void testNullHumidity() {
        SensorDataRequest request = new SensorDataRequest();
        request.setTemperature(25.0);
        request.setHumidity(null);

        assertFalse(SensorDataValidator.isValid(request), "Null humidity should return false.");
    }

    /**
     * Test case for temperature validation within range.
     */
    @Test
    void testIsTemperatureValid() {
        assertTrue(SensorDataValidator.isTemperatureValid(25.0), "Temperature within range should return true.");
        assertFalse(SensorDataValidator.isTemperatureValid(150.0), "Temperature above max should return false.");
        assertFalse(SensorDataValidator.isTemperatureValid(-60.0), "Temperature below min should return false.");
        assertFalse(SensorDataValidator.isTemperatureValid(null), "Null temperature should return false.");
    }

    /**
     * Test case for humidity validation within range.
     */
    @Test
    void testIsHumidityValid() {
        assertTrue(SensorDataValidator.isHumidityValid(50.0), "Humidity within range should return true.");
        assertFalse(SensorDataValidator.isHumidityValid(150.0), "Humidity above max should return false.");
        assertFalse(SensorDataValidator.isHumidityValid(-10.0), "Humidity below min should return false.");
        assertFalse(SensorDataValidator.isHumidityValid(null), "Null humidity should return false.");
    }
}
