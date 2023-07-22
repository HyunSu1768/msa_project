package com.example.adapter.out.event.configuration;

import com.example.adapter.in.web.rest.dto.request.SaveUserDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Configuration
public class KafkaConfiguration {

    private final KafkaProperty kafkaProperty;

    @Bean
    public ProducerFactory<String, SaveUserDto> saveUserDtoProducerFactory(){
        return new DefaultKafkaProducerFactory<>(factoryConfigs());
    }

    private Map<String, Object> factoryConfigs(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperty.getServerAddress());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return configs;
    }

    @Bean
    public KafkaTemplate<String, SaveUserDto> saveUserDtoKafkaTemplate(){
        return new KafkaTemplate<>(saveUserDtoProducerFactory());
    }

}
