package com.example.board.adapter.in.web.rest;

import com.example.board.adapter.in.web.rest.dto.request.SaveBoardDto;
import com.example.board.application.port.in.SaveBoardUseCase;
import com.example.common.annotation.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/board")
@RequiredArgsConstructor
@WebAdapter
public class BoardWebAdapter {

    private final SaveBoardUseCase saveBoardUseCase;

    @PostMapping
    public void createBoard(@RequestBody SaveBoardDto request, @RequestParam("userId") Long userId){

        saveBoardUseCase.saveBoard(request, userId);

    }
}
