package com.example.adapter.in.event;

import com.example.adapter.in.web.rest.dto.request.SaveUserDto;
import com.example.application.port.in.SaveUserUseCase;
import com.example.common.event.KafkaTopics;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveUserConsumer {

    private final SaveUserUseCase saveUserUseCase;

    @KafkaListener(topics = KafkaTopics.SAVE_USER, groupId = "msa", containerFactory = "saveUserListener")
    public void saveUserPort(SaveUserDto request) {

        saveUserUseCase.saveUser(request);

    }
}
