package com.example.board.application.port.in;

import com.example.board.adapter.in.web.rest.dto.request.SaveBoardDto;

public interface SaveBoardUseCase {

    void saveBoard(SaveBoardDto saveBoardDto, Long userId);

}
