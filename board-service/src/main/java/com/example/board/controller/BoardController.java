package com.example.board.controller;

import com.example.board.controller.dto.request.CreateBoardRequest;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public void createBoard(@RequestBody CreateBoardRequest request, @RequestParam("memberId") Long memberId){
        boardService.createBoard(request, memberId);
    }
}
