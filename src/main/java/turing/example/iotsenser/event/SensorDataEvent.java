package turing.example.iotsenser.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import turing.example.iotsenser.model.SensorData;

/**
 * Event triggered when new sensor data is received.
 * Used for asynchronous processing like anomaly detection and logging.
 */
@Getter
public class SensorDataEvent extends ApplicationEvent {

    private final SensorData sensorData;

    /**
     * Constructs a new SensorDataEvent.
     *
     * @param source      The source object triggering the event.
     * @param sensorData  The sensor data associated with the event.
     */
    public SensorDataEvent(Object source, SensorData sensorData) {
        super(source);
        this.sensorData = sensorData;
    }
}
