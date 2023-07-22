package com.example.adapter.out.event;

import com.example.adapter.in.web.rest.dto.request.SaveUserDto;
import com.example.application.port.out.rest.feignClient.SaveUserPort;
import com.example.common.event.KafkaTopics;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveUserAdapter implements SaveUserPort {

    private final KafkaTemplate<String, SaveUserDto> saveUserDtoKafkaTemplate;

    @Override
    public void saveUser(SaveUserDto saveUserDto) {

        saveUserDtoKafkaTemplate.send(KafkaTopics.SAVE_USER, saveUserDto);

    }

}
