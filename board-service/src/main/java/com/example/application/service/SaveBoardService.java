package com.example.application.service;

import com.example.application.port.out.SaveBoardPort;
import com.example.adapter.in.web.rest.dto.request.SaveBoardDto;
import com.example.application.port.in.SaveBoardUseCase;
import com.example.application.port.out.feignPort.UserFeignPort;
import com.example.common.annotation.UseCase;
import com.example.adapter.in.web.rest.dto.response.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class SaveBoardService implements SaveBoardUseCase {

    private final SaveBoardPort saveBoardPort;

    private final UserFeignPort userFeignPort;

    @Override
    public void saveBoard(SaveBoardDto saveBoardDto, Long userId) {

        UserDto userDto = userFeignPort.loadUser(userId);

        saveBoardPort.saveBoard(saveBoardDto, userDto);
    }
}
