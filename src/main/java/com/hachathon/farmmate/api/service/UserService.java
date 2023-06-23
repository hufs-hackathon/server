package com.hachathon.farmmate.api.service;

import com.hachathon.farmmate.api.domain.entity.User;
import com.hachathon.farmmate.api.domain.repository.UserRepository;
import com.hachathon.farmmate.api.dto.request.JoinRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String join(JoinRequestDto joinRequestDto) {
        userRepository.save(User.ofUser(joinRequestDto));
        return "회원가입 되었습니다.";
    }
}
