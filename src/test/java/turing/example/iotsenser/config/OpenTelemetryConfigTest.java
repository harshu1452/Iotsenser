package turing.example.iotsenser.config;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link OpenTelemetryConfig}.
 * Ensures correct bean initialization and OpenTelemetry Tracer configuration.
 */
@ExtendWith(MockitoExtension.class)
class OpenTelemetryConfigTest {

    @InjectMocks
    private OpenTelemetryConfig openTelemetryConfig;

    @Mock
    private OpenTelemetry openTelemetryMock;

    @Mock
    private Tracer tracerMock;

    /**
     * Initializes Mockito annotations before each test case.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests that the OpenTelemetry bean is properly instantiated.
     */
    @Test
    void testOpenTelemetryBean() {
        OpenTelemetry openTelemetry = openTelemetryConfig.openTelemetry();
        assertNotNull(openTelemetry, "OpenTelemetry bean should not be null.");
        assertTrue(openTelemetry instanceof OpenTelemetrySdk, "OpenTelemetry should be an instance of OpenTelemetrySdk.");
    }

    /**
     * Tests that the Tracer bean is correctly instantiated with the expected name.
     */
    @Test
    void testTracerBean() {
        when(openTelemetryMock.getTracer("iot-sensor-tracer")).thenReturn(tracerMock);

        Tracer tracer = openTelemetryConfig.tracer(openTelemetryMock);
        assertNotNull(tracer, "Tracer bean should not be null.");
        assertEquals(tracerMock, tracer, "Tracer instance should match the mocked tracer.");
    }
}
