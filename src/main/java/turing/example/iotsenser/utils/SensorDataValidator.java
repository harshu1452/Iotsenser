package turing.example.iotsenser.utils;

import turing.example.iotsenser.dto.SensorDataRequest;

/**
 * Utility class for validating sensor data before processing.
 * Ensures that values fall within acceptable thresholds.
 */
public class SensorDataValidator {

    // Define acceptable threshold values
    private static final double MIN_TEMPERATURE = -50.0;
    private static final double MAX_TEMPERATURE = 100.0;
    private static final double MIN_HUMIDITY = 0.0;
    private static final double MAX_HUMIDITY = 100.0;

    /**
     * Validates the sensor data request for acceptable value ranges.
     *
     * @param request The sensor data request DTO containing device readings.
     * @return True if the data is valid, false otherwise.
     */
    public static boolean isValid(SensorDataRequest request) {
        return isTemperatureValid(request.getTemperature()) && isHumidityValid(request.getHumidity());
    }

    /**
     * Validates if the temperature falls within the acceptable range.
     *
     * @param temperature The temperature value to validate.
     * @return True if the temperature is within range, false otherwise.
     */
    public static boolean isTemperatureValid(Double temperature) {
        return temperature != null && temperature >= MIN_TEMPERATURE && temperature <= MAX_TEMPERATURE;
    }

    /**
     * Validates if the humidity falls within the acceptable range.
     *
     * @param humidity The humidity value to validate.
     * @return True if the humidity is within range, false otherwise.
     */
    public static boolean isHumidityValid(Double humidity) {
        return humidity != null && humidity >= MIN_HUMIDITY && humidity <= MAX_HUMIDITY;
    }
}
