package com.hachathon.farmmate.api.dto.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ActivityBoardsResponseDto {
    private String category;
    private List<ActivityBoardResponseDto> activityBoardResponseDtoList;

}
