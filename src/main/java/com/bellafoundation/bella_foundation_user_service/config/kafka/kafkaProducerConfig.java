package com.bellafoundation.bella_foundation_user_service.config.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class kafkaProducerConfig {
    @Value(value ="${kafka.bootStrapAddress}")
    private String bootStrapAddress;

    @Value(value="${sasl.jaas.config}")
    private String saslJaasConfig;

    @Value(value = "${sasl.mechanism}")
    private String saslMechanism;

    @Value(value = "${security,protocal}")
    private String securityProtocal;

    @Bean
    public ProducerFactory<String, String> producerFactory(){
        Map<String, Object> configProps= new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapAddress);
        configProps.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG,"6000000000000000");
        configProps.put(ProducerConfig.ACKS_CONFIG,"all");
        configProps.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,"1");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);

        configProps.put("sasl.mechanism",saslMechanism);
        configProps.put("sasl.jaas.config",saslJaasConfig);
        configProps.put("security.protocal",securityProtocal);

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
