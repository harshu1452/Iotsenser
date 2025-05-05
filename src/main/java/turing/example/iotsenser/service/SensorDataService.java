package turing.example.iotsenser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turing.example.iotsenser.model.SensorData;
import turing.example.iotsenser.repository.SensorDataRepository;

import java.util.List;

/**
 * Service for managing IoT sensor data.
 * Handles data persistence and retrieval operations.
 */
@Service
public class SensorDataService {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    /**
     * Constructor-based dependency injection for repository access.
     *
     * @param sensorDataRepository Repository for accessing sensor data.
     */
//    @Autowired
//    public SensorDataService(SensorDataRepository sensorDataRepository) {
//        this.sensorDataRepository = sensorDataRepository;
//    }

    /**
     * Saves sensor data to the database.
     *
     * @param sensorData The sensor data to be saved.
     * @return The saved SensorData entity.
     */
    public SensorData saveSensorData(SensorData sensorData) {
        return sensorDataRepository.save(sensorData);
    }

    /**
     * Retrieves all stored sensor data.
     *
     * @return List of all SensorData records.
     */
    public List<SensorData> getAllSensorData() {
        return sensorDataRepository.findAll();
    }

    /**
     * Retrieves sensor data for a specific IoT device.
     *
     * @param deviceId Unique identifier of the IoT device.
     * @return List of SensorData records for the given device.
     */
    public List<SensorData> getSensorDataByDevice(String deviceId) {
        return sensorDataRepository.findByDeviceId(deviceId);
    }
}
