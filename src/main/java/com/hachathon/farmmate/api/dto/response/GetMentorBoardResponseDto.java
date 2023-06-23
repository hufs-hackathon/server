package com.hachathon.farmmate.api.dto.response;

import com.hachathon.farmmate.api.domain.entity.MenteeBoard;
import com.hachathon.farmmate.api.domain.entity.MentorBoard;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMentorBoardResponseDto {

    private Long boardId;

    private String title;

    private String nickname;

    private String major;

    private Integer isMentor;

    public static GetMentorBoardResponseDto from(MentorBoard mentorBoard) {
        return GetMentorBoardResponseDto.builder()
                                        .boardId(mentorBoard.getId())
                                        .title(mentorBoard.getTitle())
                                        .nickname(mentorBoard.getUser().getNickname())
                                        .major(mentorBoard.getUser().getMajor())
                                        .isMentor(1)
                                        .build();
    }

    public static GetMentorBoardResponseDto from(MenteeBoard menteeBoard) {
        return GetMentorBoardResponseDto.builder()
                                        .title(menteeBoard.getTitle())
                                        .nickname(menteeBoard.getUser().getNickname())
                                        .major(menteeBoard.getUser().getMajor())
                                        .isMentor(0)
                                        .build();
    }
}
