package com.hachathon.farmmate.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MenteeBoardResponseDto {
    private String title;
    private String content;
    private String category;
    private Long menteeId;
    private Long boardId;
    private String nickname;
    private String email;
    private String imageUrl;
    private String major;
}
