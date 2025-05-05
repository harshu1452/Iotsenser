package turing.example.iotsenser.event;

import org.junit.jupiter.api.Test;
import turing.example.iotsenser.model.SensorData;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the SensorDataEvent class.
 * Ensures that the event is created correctly and holds the expected data.
 */
class SensorDataEventTest {

    /**
     * Test case to verify that the SensorDataEvent is correctly instantiated
     * and that the provided SensorData object is correctly stored.
     */
    @Test
    void testSensorDataEventCreation() {
        // Given: Sample sensor data
        SensorData sensorData = new SensorData();
        sensorData.setDeviceId("device123");
        sensorData.setTemperature(22.5);
        sensorData.setHumidity(55.0);
        sensorData.setTimestamp(LocalDateTime.now());

        // When: Creating a new SensorDataEvent
        SensorDataEvent event = new SensorDataEvent(this, sensorData);

        // Then: Ensure the event is correctly initialized
        assertNotNull(event, "SensorDataEvent should not be null.");
        assertEquals(this, event.getSource(), "Event source should be correctly set.");
        assertEquals(sensorData, event.getSensorData(), "SensorData should be correctly stored in the event.");
    }
}
