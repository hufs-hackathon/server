package com.hachathon.farmmate.api.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyPageScrapedResponseDto {

    private String title;

    private String introduce;

    private String userImageUrl;

    private String major;

    private String nickname;

    private Integer role;
}
