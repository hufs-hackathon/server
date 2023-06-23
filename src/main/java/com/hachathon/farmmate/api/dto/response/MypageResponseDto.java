package com.hachathon.farmmate.api.dto.response;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MypageResponseDto {
    private Long userId;
    private String email;
    private String nickname;
    private String major;
    private String univ;
    private Integer role;

    @Builder
    public MypageResponseDto(Long userId, String email, String nickname, String major, String univ, Integer role) {
        this.userId = userId;
        this.email = email;
        this.nickname = nickname;
        this.major = major;
        this.univ = univ;
        this.role = role;
    }
}
