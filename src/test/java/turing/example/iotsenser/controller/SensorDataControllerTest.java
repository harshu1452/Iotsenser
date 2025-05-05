package turing.example.iotsenser.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import turing.example.iotsenser.model.SensorData;
import turing.example.iotsenser.service.SensorDataService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SensorDataControllerTest {

    @InjectMocks
    private SensorDataController sensorDataController;

    @Mock
    private SensorDataService sensorDataService;

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    private SensorData sensorData;

    @BeforeEach
    void setUp() {
        sensorData = new SensorData();
        sensorData.setDeviceId("device123");
        sensorData.setTemperature(25.5);
        sensorData.setHumidity(60.0);
    }

    /**
     * Test case for ingesting sensor data.
     * Ensures the service layer is called and data is sent to Kafka.
     */
    @Test
    void testIngestSensorData() {
        ResponseEntity<String> response = sensorDataController.ingestSensorData(sensorData);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Sensor data ingested successfully.", response.getBody());

        verify(sensorDataService, times(1)).saveSensorData(sensorData);
        verify(kafkaTemplate, times(1)).send("sensor-data", sensorData.toString());
    }

    /**
     * Test case for retrieving all sensor data.
     * Ensures the response contains the expected list.
     */
    @Test
    void testGetAllSensorData() {
        List<SensorData> mockData = Arrays.asList(sensorData);
        when(sensorDataService.getAllSensorData()).thenReturn(mockData);

        ResponseEntity<List<SensorData>> response = sensorDataController.getAllSensorData();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("device123", response.getBody().get(0).getDeviceId());

        verify(sensorDataService, times(1)).getAllSensorData();
    }

    /**
     * Test case for retrieving sensor data by device ID.
     * Ensures correct filtering and response.
     */
    @Test
    void testGetSensorDataByDevice() {
        List<SensorData> mockData = Arrays.asList(sensorData);
        when(sensorDataService.getSensorDataByDevice("device123")).thenReturn(mockData);

        ResponseEntity<List<SensorData>> response = sensorDataController.getSensorDataByDevice("device123");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("device123", response.getBody().get(0).getDeviceId());

        verify(sensorDataService, times(1)).getSensorDataByDevice("device123");
    }

    /**
     * Test case for the health check endpoint.
     * Ensures it returns the correct status message.
     */
    @Test
    void testHealthCheck() {
        ResponseEntity<String> response = sensorDataController.healthCheck();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Sensor Data Service is up and running.", response.getBody());
    }
}
