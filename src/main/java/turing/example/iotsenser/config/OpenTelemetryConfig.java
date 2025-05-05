package turing.example.iotsenser.config;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for OpenTelemetry Tracing.
 */
@Configuration
public class OpenTelemetryConfig {

    /**
     * Configures OpenTelemetry Tracer.
     */
    @Bean
    public OpenTelemetry openTelemetry() {
        return OpenTelemetrySdk.builder().build();
    }

    /**
     * Provides a Tracer instance for tracking requests.
     */
    @Bean
    public Tracer tracer(OpenTelemetry openTelemetry) {
        return openTelemetry.getTracer("iot-sensor-tracer");
    }
}
