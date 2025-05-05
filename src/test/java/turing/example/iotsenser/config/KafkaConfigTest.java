package turing.example.iotsenser.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for KafkaConfig.
 * Ensures that Kafka Producer and Consumer configurations are properly set up.
 */
@ExtendWith(MockitoExtension.class)
class KafkaConfigTest {

    @InjectMocks
    private KafkaConfig kafkaConfig;

    @Mock
    private ProducerFactory<String, String> producerFactoryMock;

    @Mock
    private ConsumerFactory<String, String> consumerFactoryMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        kafkaConfig = new KafkaConfig();
    }

    /**
     * Tests that the Kafka topic bean is correctly created.
     */
    @Test
    void testTopicCreation() {
        NewTopic topic = kafkaConfig.topic();
        assertNotNull(topic, "Kafka topic should not be null.");
        assertEquals("sensor-data", topic.name(), "Kafka topic name should match.");
        assertEquals(3, topic.numPartitions(), "Kafka topic should have 3 partitions.");
        assertEquals((short) 1, topic.replicationFactor(), "Kafka topic replication factor should be 1.");
    }

    /**
     * Tests that the Kafka ProducerFactory is properly configured.
     */
    @Test
    void testProducerFactoryConfiguration() {
        ProducerFactory<String, String> producerFactory = kafkaConfig.producerFactory();
        assertNotNull(producerFactory, "ProducerFactory should not be null.");

        // Verify producer configurations
        Map<String, Object> configProps = ((DefaultKafkaProducerFactory<String, String>) producerFactory).getConfigurationProperties();
        assertEquals("localhost:9092", configProps.get(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG), "Producer bootstrap servers should match.");
        assertEquals(StringSerializer.class, configProps.get(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG), "Producer key serializer should match.");
        assertEquals(StringSerializer.class, configProps.get(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG), "Producer value serializer should match.");
    }

    /**
     * Tests that the KafkaTemplate bean is correctly created.
     */
//    @Test
//    void testKafkaTemplateCreation() {
//        KafkaTemplate<String, String> kafkaTemplate = kafkaConfig.kafkaTemplate();
//        assertNotNull(kafkaTemplate, "KafkaTemplate should not be null.");
//        assertEquals(producerFactoryMock.getClass(), kafkaTemplate.getProducerFactory().getClass(), "KafkaTemplate should use the correct ProducerFactory.");
//    }

    /**
     * Tests that the Kafka ConsumerFactory is properly configured.
     */
    @Test
    void testConsumerFactoryConfiguration() {
        ConsumerFactory<String, String> consumerFactory = kafkaConfig.consumerFactory();
        assertNotNull(consumerFactory, "ConsumerFactory should not be null.");

        // Verify consumer configurations
        Map<String, Object> configProps = ((DefaultKafkaConsumerFactory<String, String>) consumerFactory).getConfigurationProperties();
        assertEquals("localhost:9092", configProps.get(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG), "Consumer bootstrap servers should match.");
        assertEquals("sensor-group", configProps.get(ConsumerConfig.GROUP_ID_CONFIG), "Consumer group ID should match.");
        assertEquals(StringDeserializer.class, configProps.get(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG), "Consumer key deserializer should match.");
        assertEquals(StringDeserializer.class, configProps.get(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG), "Consumer value deserializer should match.");
    }

}
