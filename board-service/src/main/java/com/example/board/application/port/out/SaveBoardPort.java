package com.example.board.application.port.out;

import com.example.board.adapter.in.web.rest.dto.request.SaveBoardDto;
import com.example.user.adapter.in.web.rest.dto.response.UserDto;

public interface SaveBoardPort {

    void saveBoard(SaveBoardDto saveBoardDto, UserDto dto);

}
