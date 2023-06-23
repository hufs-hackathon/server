package com.hachathon.farmmate.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class SpecificActivityBoardResponseDto {
    private String title;
    private String content;
    private String imageUrl;
    private String tag;
}
