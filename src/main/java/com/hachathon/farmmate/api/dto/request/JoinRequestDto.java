package com.hachathon.farmmate.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class JoinRequestDto {
    private final String email;
    private final String nickname;
    private final String major;
    private final String univ;
    private final String role;
}
