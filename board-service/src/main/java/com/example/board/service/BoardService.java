package com.example.board.service;

import com.example.board.controller.dto.request.CreateBoardRequest;
import com.example.board.domain.Board;
import com.example.board.infra.feign.UserFeignClient;
import com.example.board.infra.feign.dto.MemberInfoResponse;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    private final UserFeignClient userFeignClient;

    public void createBoard(CreateBoardRequest request, Long memberId){

        MemberInfoResponse memberInfoResponse = userFeignClient.loadUser(memberId);

        Board board = Board.builder()
                .description(request.getDescription())
                .title(request.getTitle())
                .writer(memberInfoResponse.getName())
                .build();

        boardRepository.save(board);
    }

}
