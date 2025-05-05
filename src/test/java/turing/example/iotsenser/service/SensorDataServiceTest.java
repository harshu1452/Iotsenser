package turing.example.iotsenser.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import turing.example.iotsenser.model.SensorData;
import turing.example.iotsenser.repository.SensorDataRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for SensorDataService.
 * Ensures correct behavior for sensor data management operations.
 */
@ExtendWith(MockitoExtension.class)
class SensorDataServiceTest {

    @Mock
    private SensorDataRepository sensorDataRepository;

    @InjectMocks
    private SensorDataService sensorDataService;

    private SensorData sampleData1;
    private SensorData sampleData2;

    /**
     * Sets up test data before each test case runs.
     */
    @BeforeEach
    void setUp() {
        sampleData1 = new SensorData(1L, "device123", 25.0, 60.0, LocalDateTime.now());
        sampleData2 = new SensorData(2L, "device456", 30.0, 70.0, LocalDateTime.now());
    }

    /**
     * Test case for saving sensor data.
     */
    @Test
    void testSaveSensorData() {
        // Given: A sensor data object
        when(sensorDataRepository.save(sampleData1)).thenReturn(sampleData1);

        // When: Saving sensor data
        SensorData savedData = sensorDataService.saveSensorData(sampleData1);

        // Then: Ensure the data is correctly saved and returned
        assertNotNull(savedData, "Saved data should not be null.");
        assertEquals(sampleData1.getDeviceId(), savedData.getDeviceId(), "Device ID should match.");
        assertEquals(sampleData1.getTemperature(), savedData.getTemperature(), "Temperature should match.");
        assertEquals(sampleData1.getHumidity(), savedData.getHumidity(), "Humidity should match.");

        // Verify repository interaction
        verify(sensorDataRepository, times(1)).save(sampleData1);
    }

    /**
     * Test case for retrieving all sensor data.
     */
    @Test
    void testGetAllSensorData() {
        // Given: A list of sensor data
        List<SensorData> mockDataList = List.of(sampleData1, sampleData2);
        when(sensorDataRepository.findAll()).thenReturn(mockDataList);

        // When: Retrieving all sensor data
        List<SensorData> result = sensorDataService.getAllSensorData();

        // Then: Ensure the correct data is retrieved
        assertEquals(2, result.size(), "Should return exactly 2 sensor data entries.");
        assertTrue(result.contains(sampleData1), "List should contain sampleData1.");
        assertTrue(result.contains(sampleData2), "List should contain sampleData2.");

        // Verify repository interaction
        verify(sensorDataRepository, times(1)).findAll();
    }

    /**
     * Test case for retrieving sensor data by device ID.
     */
    @Test
    void testGetSensorDataByDevice() {
        // Given: Sensor data belonging to a specific device
        List<SensorData> deviceData = List.of(sampleData1);
        when(sensorDataRepository.findByDeviceId("device123")).thenReturn(deviceData);

        // When: Retrieving data for a specific device
        List<SensorData> result = sensorDataService.getSensorDataByDevice("device123");

        // Then: Ensure the correct data is returned
        assertEquals(1, result.size(), "Should return exactly 1 entry.");
        assertEquals(sampleData1, result.get(0), "Returned data should match sampleData1.");

        // Verify repository interaction
        verify(sensorDataRepository, times(1)).findByDeviceId("device123");
    }
}
