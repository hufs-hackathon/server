package com.hachathon.farmmate.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ActivityBoardResponseDto {
    private Long BoardId;
    private String title;
    private String imageUrl;
    private String tag;
}
