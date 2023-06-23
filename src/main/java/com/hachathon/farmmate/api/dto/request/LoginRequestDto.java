package com.hachathon.farmmate.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LoginRequestDto {
    private String email;
    private String nickname;
    private String imageUrl;
}
