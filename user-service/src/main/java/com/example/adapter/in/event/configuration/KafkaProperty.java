package com.example.adapter.in.event.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@Setter
@ConfigurationProperties("kafka")
@ConstructorBinding
public class KafkaProperty {

    private String serverAddress;

}
