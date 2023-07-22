package com.example.adapter.in.event.configuration;

import com.example.adapter.in.web.rest.dto.request.SaveUserDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Configuration
public class KafkaConfiguration {

    private final KafkaProperty kafkaProperty;

    @Bean
    public ConsumerFactory<String, SaveUserDto> saveUserDtoConsumerFactory(){
        return new DefaultKafkaConsumerFactory<>(
                factoryConfigs(),
                new StringDeserializer(),
                new JsonDeserializer<>(SaveUserDto.class)
        );
    }

    private Map<String, Object> factoryConfigs(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperty.getServerAddress());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return configs;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SaveUserDto> saveUserListener(){
        ConcurrentKafkaListenerContainerFactory<String, SaveUserDto> factory
                = new ConcurrentKafkaListenerContainerFactory<String, SaveUserDto>();
        factory.setConsumerFactory(saveUserDtoConsumerFactory());
        return factory;
    }

}
