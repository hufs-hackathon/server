package com.hachathon.farmmate.api.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMentorBoardDetailResponseDto {

    private String title;

    private String nickname;

    private String content;

    private String major;

    private String userImageUrl;

    private String email;

    private String category;

    private List<FaqResponseDto> faqList;

}
