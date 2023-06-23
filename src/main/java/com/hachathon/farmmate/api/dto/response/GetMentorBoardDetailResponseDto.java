package com.hachathon.farmmate.api.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMentorBoardDetailResponseDto {

    private Long boardId;

    private String title;

    private String nickname;

    private String introduce;

    private String major;

    private String userImageUrl;

    private String email;

    private String category;

    private List<FaqDto> faqList;

}
