package turing.example.iotsenser.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SensorDataRequestTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Test case to validate a correctly populated SensorDataRequest object.
     * Ensures no validation errors occur.
     */
    @Test
    void testValidSensorDataRequest() {
        SensorDataRequest request = new SensorDataRequest();
        request.setDeviceId("device123");
        request.setTemperature(25.5);
        request.setHumidity(60.0);

        Set<ConstraintViolation<SensorDataRequest>> violations = validator.validate(request);

        assertTrue(violations.isEmpty(), "No validation errors should occur for a valid request.");
        assertNotNull(request.getTimestamp(), "Timestamp should not be null.");
    }

    /**
     * Test case for an empty device ID.
     * Ensures validation catches the blank device ID field.
     */
    @Test
    void testInvalidDeviceId() {
        SensorDataRequest request = new SensorDataRequest();
        request.setDeviceId("");
        request.setTemperature(25.5);
        request.setHumidity(60.0);

        Set<ConstraintViolation<SensorDataRequest>> violations = validator.validate(request);

        assertEquals(1, violations.size(), "One validation error should occur for an empty device ID.");
        assertTrue(violations.iterator().next().getMessage().contains("Device ID cannot be empty"));
    }

    /**
     * Test case for a missing temperature value.
     * Ensures validation catches the null temperature field.
     */
    @Test
    void testMissingTemperature() {
        SensorDataRequest request = new SensorDataRequest();
        request.setDeviceId("device123");
        request.setHumidity(60.0);
        request.setTemperature(null);

        Set<ConstraintViolation<SensorDataRequest>> violations = validator.validate(request);

        assertEquals(1, violations.size(), "One validation error should occur for missing temperature.");
        assertTrue(violations.iterator().next().getMessage().contains("Temperature is required"));
    }

    /**
     * Test case for a negative temperature value.
     * Ensures validation catches negative temperature values.
     */
    @Test
    void testNegativeTemperature() {
        SensorDataRequest request = new SensorDataRequest();
        request.setDeviceId("device123");
        request.setTemperature(-5.0);
        request.setHumidity(60.0);

        Set<ConstraintViolation<SensorDataRequest>> violations = validator.validate(request);

        assertEquals(1, violations.size(), "One validation error should occur for negative temperature.");
        assertTrue(violations.iterator().next().getMessage().contains("Temperature must be greater than zero"));
    }

    /**
     * Test case for a missing humidity value.
     * Ensures validation catches the null humidity field.
     */
    @Test
    void testMissingHumidity() {
        SensorDataRequest request = new SensorDataRequest();
        request.setDeviceId("device123");
        request.setTemperature(25.5);
        request.setHumidity(null);

        Set<ConstraintViolation<SensorDataRequest>> violations = validator.validate(request);

        assertEquals(1, violations.size(), "One validation error should occur for missing humidity.");
        assertTrue(violations.iterator().next().getMessage().contains("Humidity is required"));
    }

    /**
     * Test case for a negative humidity value.
     * Ensures validation catches negative humidity values.
     */
    @Test
    void testNegativeHumidity() {
        SensorDataRequest request = new SensorDataRequest();
        request.setDeviceId("device123");
        request.setTemperature(25.5);
        request.setHumidity(-10.0);

        Set<ConstraintViolation<SensorDataRequest>> violations = validator.validate(request);

        assertEquals(1, violations.size(), "One validation error should occur for negative humidity.");
        assertTrue(violations.iterator().next().getMessage().contains("Humidity must be greater than zero"));
    }

    /**
     * Test case to verify that the default timestamp is correctly set.
     * Ensures the timestamp is automatically assigned when not provided.
     */
    @Test
    void testDefaultTimestamp() {
        SensorDataRequest request = new SensorDataRequest();
        request.setDeviceId("device123");
        request.setTemperature(25.5);
        request.setHumidity(60.0);

        assertNotNull(request.getTimestamp(), "Timestamp should be auto-assigned.");
    }
    /**
     * Tests that an empty deviceId violates the @NotBlank constraint.
     */
    @Test
    void testDeviceIdNotBlankConstraint() {
        SensorDataRequest request = new SensorDataRequest();
        request.setDeviceId("");

        Set<ConstraintViolation<SensorDataRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "Validation should fail for empty deviceId");
    }
    /**
     * Tests that a null temperature violates the @NotNull constraint.
     */
    @Test
    void testTemperatureNotNullConstraint() {
        SensorDataRequest request = new SensorDataRequest();
        request.setTemperature(null);

        Set<ConstraintViolation<SensorDataRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "Validation should fail for null temperature");
    }

    /**
     * Tests that a negative temperature violates the @Positive constraint.
     */
    @Test
    void testTemperaturePositiveConstraint() {
        SensorDataRequest request = new SensorDataRequest();
        request.setTemperature(-5.0);

        Set<ConstraintViolation<SensorDataRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "Validation should fail for negative temperature");
    }

    /**
     * Tests that a null humidity violates the @NotNull constraint.
     */
    @Test
    void testHumidityNotNullConstraint() {
        SensorDataRequest request = new SensorDataRequest();
        request.setHumidity(null);

        Set<ConstraintViolation<SensorDataRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "Validation should fail for null humidity");
    }

    /**
     * Tests that a negative humidity violates the @Positive constraint.
     */
    @Test
    void testHumidityPositiveConstraint() {
        SensorDataRequest request = new SensorDataRequest();
        request.setHumidity(-3.0);

        Set<ConstraintViolation<SensorDataRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "Validation should fail for negative humidity");
    }

}
