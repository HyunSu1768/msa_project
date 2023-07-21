package com.example.board.adapter.in.web.rest.dto.request;

import com.example.board.domain.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveBoardDto {

    private String title;

    private String description;

    public Board toBoard(String writer){
        return Board.builder()
                .writer(writer)
                .title(this.getTitle())
                .description(this.getDescription())
                .build();
    }

}
