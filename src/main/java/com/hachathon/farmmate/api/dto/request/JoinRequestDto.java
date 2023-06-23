package com.hachathon.farmmate.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class JoinRequestDto {
    private final String email;
    private final String nickname;
    private final String major;
    private final String univ;
    private final Integer role;
    private final String imageUrl;
}
