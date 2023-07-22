package com.example.application.port.in;

import com.example.adapter.in.web.rest.dto.request.SaveBoardDto;

public interface SaveBoardUseCase {

    void saveBoard(SaveBoardDto saveBoardDto, Long userId);

}
