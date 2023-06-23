package com.hachathon.farmmate.api.dto.response;

import com.hachathon.farmmate.api.domain.entity.MentorBoard;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMentorBoardResponseDto {

    private String title;

    private String nickname;

    private String major;

    private Integer isMentor;

    public static GetMentorBoardResponseDto from(MentorBoard mentorBoard) {
        return GetMentorBoardResponseDto.builder()
                                        .title(mentorBoard.getTitle())
                                        .nickname(mentorBoard.getUser().getNickname())
                                        .major(mentorBoard.getUser().getMajor())
                                        .isMentor(1)
                                        .build();
    }
}
