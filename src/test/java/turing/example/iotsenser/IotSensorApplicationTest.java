package turing.example.iotsenser;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/// Unit tests for [turing.example.iotsenser.IotSensorApplication].
/// Ensures application starts correctly.
class IotSensorApplicationTest {

    /**
     * Tests that the main method runs without throwing exceptions.
     */
    @Test
    void testMainMethod() {
        try (MockedStatic<SpringApplication> mockedSpringApplication = Mockito.mockStatic(SpringApplication.class)) {
            assertDoesNotThrow(() -> IotSensorApplication.main(new String[]{}),
                    "Main method should run without throwing exceptions.");
            mockedSpringApplication.verify(() -> SpringApplication.run(IotSensorApplication.class, new String[]{}));
        }
    }
}
