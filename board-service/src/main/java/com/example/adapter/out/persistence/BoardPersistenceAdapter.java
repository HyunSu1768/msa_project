package com.example.adapter.out.persistence;

import com.example.adapter.in.web.rest.dto.request.SaveBoardDto;
import com.example.adapter.out.persistence.repository.BoardRepository;
import com.example.application.port.out.SaveBoardPort;
import com.example.common.annotation.PersistenceAdapter;
import com.example.adapter.in.web.rest.dto.response.UserDto;
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
