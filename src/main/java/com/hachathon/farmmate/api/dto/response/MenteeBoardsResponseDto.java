package com.hachathon.farmmate.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MenteeBoardsResponseDto {
    private Long menteeId;
    private Integer role;
    private String title;
    private String nickname;
    private String major;
    private String imageUrl;
}
