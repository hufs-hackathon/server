package com.hachathon.farmmate.api.service;

import com.hachathon.farmmate.api.domain.entity.MenteeBoard;
import com.hachathon.farmmate.api.domain.entity.MentorBoard;
import com.hachathon.farmmate.api.domain.entity.ScrapedBoard;
import com.hachathon.farmmate.api.domain.entity.User;
import com.hachathon.farmmate.api.domain.repository.MenteeBoardRepository;
import com.hachathon.farmmate.api.domain.repository.MentorBoardRepository;
import com.hachathon.farmmate.api.domain.repository.ScrapedBoardRepository;
import com.hachathon.farmmate.api.domain.repository.UserRepository;
import com.hachathon.farmmate.api.dto.request.JoinRequestDto;
import com.hachathon.farmmate.api.dto.request.LoginRequestDto;
import com.hachathon.farmmate.api.dto.response.GetMentorBoardResponseDto;
import com.hachathon.farmmate.api.dto.response.MyPageScrapedResponseDto;
import com.hachathon.farmmate.api.dto.response.MypageResponseDto;
import com.hachathon.farmmate.exception.CustomException;
import com.hachathon.farmmate.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final MentorBoardRepository mentorBoardRepository;
    private final MenteeBoardRepository menteeBoardRepository;
    private final ScrapedBoardRepository scrapedBoardRepository;

    public Long login(LoginRequestDto loginRequestDto) {
        Optional<User> userCheck = userRepository.findByEmail(loginRequestDto.getEmail());
        if (!userCheck.isEmpty()) {
            return userCheck.get().getId();
        } else {
            return 0L;
        }
    }

    @Transactional
    public Long join(JoinRequestDto joinRequestDto) {
        User user = userRepository.save(User.ofUser(joinRequestDto));

        return user.getId();
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

    @Transactional
    public Boolean scrapBoard(Long userId, Long boardId) {
        User user = getUser(userId);

        Optional<ScrapedBoard> optionalScrapedBoard
                = this.scrapedBoardRepository.findByUserAndBoardId(user, boardId);

        if (optionalScrapedBoard.isEmpty()) {
            this.scrapedBoardRepository.save(
                    ScrapedBoard.builder()
                                .user(user)
                                .boardId(boardId)
                                .build()
            );
            return true;
        } else {
            return false;
        }
    }


    @Transactional(readOnly = true)
    public List<MyPageScrapedResponseDto> getMyScrapResult(Long userId) {

        User user = getUser(userId);

        List<ScrapedBoard> scrapedBoards = this.scrapedBoardRepository.findByUser(user);
        List<MyPageScrapedResponseDto> result = new ArrayList<>();

        if (user.getRole() == 0) {
            for (ScrapedBoard board : scrapedBoards) {
                MenteeBoard mentorBoard = this.menteeBoardRepository.findById(board.getBoardId())
                                                                    .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_POSTING));
                result.add(
                        MyPageScrapedResponseDto
                                .builder()
                                .title(mentorBoard.getTitle())
                                .introduce(mentorBoard.getIntroduce())
                                .userImageUrl(user.getImageUrl())
                                .major(user.getMajor())
                                .nickname(user.getNickname())
                                .role(user.getRole())
                                .build()
                );
            }
        } else {
            for (ScrapedBoard board : scrapedBoards) {
                MentorBoard menteeBoard = this.mentorBoardRepository.findById(board.getId())
                                                                    .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_POSTING));
                result.add(
                        MyPageScrapedResponseDto
                                .builder()
                                .title(menteeBoard.getTitle())
                                .introduce(menteeBoard.getIntroduce())
                                .userImageUrl(user.getImageUrl())
                                .major(user.getMajor())
                                .nickname(user.getNickname())
                                .role(user.getRole())
                                .build()
                );
            }
        }
        return result;
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }
}
