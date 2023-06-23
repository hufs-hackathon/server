package com.hachathon.farmmate.api.service;

import com.hachathon.farmmate.api.domain.entity.User;
import com.hachathon.farmmate.api.domain.repository.MenteeBoardRepository;
import com.hachathon.farmmate.api.domain.repository.MentorBoardRepository;
import com.hachathon.farmmate.api.domain.repository.UserRepository;
import com.hachathon.farmmate.api.dto.request.JoinRequestDto;
import com.hachathon.farmmate.api.dto.response.GetMentorBoardResponseDto;
import com.hachathon.farmmate.api.dto.response.MypageResponseDto;
import com.hachathon.farmmate.exception.CustomException;
import com.hachathon.farmmate.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final MentorBoardRepository mentorBoardRepository;
    private final MenteeBoardRepository menteeBoardRepository;

    public String join(JoinRequestDto joinRequestDto) {
        userRepository.save(User.ofUser(joinRequestDto));
        return "회원가입 되었습니다.";
    }

    public MypageResponseDto mypage(Long userId) {
        User user = getUser(userId);
        return MypageResponseDto.builder()
                                .userId(user.getId())
                                .email(user.getEmail())
                                .nickname(user.getNickname())
                                .major(user.getMajor())
                                .univ(user.getUniv())
                                .role(user.getRole())
                                .build();
    }

    public List<GetMentorBoardResponseDto> getMyPost(Long userId) {
        User user = getUser(userId);

        if (user.getRole() == 0) {
            return this.mentorBoardRepository.findAllByUser(user)
                                             .stream()
                                             .map(GetMentorBoardResponseDto::from)
                                             .collect(Collectors.toList());
        } else {
            return this.menteeBoardRepository.findAllByUser(user)
                                             .stream()
                                             .map(GetMentorBoardResponseDto::from)
                                             .collect(Collectors.toList());
        }
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }
}
