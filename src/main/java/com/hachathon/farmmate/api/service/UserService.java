package com.hachathon.farmmate.api.service;

import com.hachathon.farmmate.api.domain.entity.User;
import com.hachathon.farmmate.api.domain.repository.UserRepository;
import com.hachathon.farmmate.api.dto.request.JoinRequestDto;
import com.hachathon.farmmate.api.dto.response.MypageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String join(JoinRequestDto joinRequestDto) {
        userRepository.save(User.ofUser(joinRequestDto));
        return "회원가입 되었습니다.";
    }

    public MypageResponseDto mypage(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id=" + userId));
        return MypageResponseDto.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .major(user.getMajor())
                .univ(user.getUniv())
                .role(user.getRole())
                .build();
    }
}
