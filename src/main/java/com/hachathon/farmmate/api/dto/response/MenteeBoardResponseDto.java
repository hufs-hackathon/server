package com.hachathon.farmmate.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MenteeBoardResponseDto {
    private List<String> imageUrlList;
    private String title;
    private String content;
    private String category;
}
