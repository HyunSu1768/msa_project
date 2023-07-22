package com.example.application.port.out;

import com.example.adapter.in.web.rest.dto.request.SaveBoardDto;
import com.example.adapter.in.web.rest.dto.response.UserDto;

public interface SaveBoardPort {

    void saveBoard(SaveBoardDto saveBoardDto, UserDto dto);

}
