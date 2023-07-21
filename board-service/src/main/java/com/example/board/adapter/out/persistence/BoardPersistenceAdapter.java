package com.example.board.adapter.out.persistence;

import com.example.board.adapter.in.web.rest.dto.request.SaveBoardDto;
import com.example.board.adapter.out.persistence.repository.BoardRepository;
import com.example.board.application.port.out.SaveBoardPort;
import com.example.board.application.port.out.feignPort.UserFeignPort;
import com.example.common.annotation.PersistenceAdapter;
import com.example.user.adapter.in.web.rest.dto.response.UserDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class BoardPersistenceAdapter implements SaveBoardPort {

    private final BoardRepository boardRepository;

    @Override
    public void saveBoard(SaveBoardDto saveBoardDto, UserDto dto) {

        boardRepository.save(saveBoardDto.toBoard(dto.getName()));

    }

}
