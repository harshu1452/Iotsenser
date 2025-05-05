package turing.example.iotsenser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import turing.example.iotsenser.model.SensorData;

import java.util.List;

/**
 * Repository interface for managing SensorData persistence.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

    /**
     * Finds all sensor data records for a specific device ID.
     *
     * @param deviceId Unique identifier of the IoT device.
     * @return List of SensorData records associated with the given device ID.
     */
    List<SensorData> findByDeviceId(String deviceId);

}
