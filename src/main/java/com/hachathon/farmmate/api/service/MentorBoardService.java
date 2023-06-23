package com.hachathon.farmmate.api.service;

import com.hachathon.farmmate.api.domain.entity.Faq;
import com.hachathon.farmmate.api.domain.entity.MentorBoard;
import com.hachathon.farmmate.api.domain.entity.User;
import com.hachathon.farmmate.api.domain.repository.FaqRepository;
import com.hachathon.farmmate.api.domain.repository.MentorBoardRepository;
import com.hachathon.farmmate.api.domain.repository.UserRepository;
import com.hachathon.farmmate.api.dto.request.RegisterMentorBoardRequestDto;
import com.hachathon.farmmate.api.dto.response.FaqDto;
import com.hachathon.farmmate.api.dto.response.GetMentorBoardDetailResponseDto;
import com.hachathon.farmmate.api.dto.response.GetMentorBoardResponseDto;
import com.hachathon.farmmate.exception.CustomException;
import com.hachathon.farmmate.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MentorBoardService {

    private final MentorBoardRepository mentorBoardRepository;
    private final FaqRepository faqRepository;
    private final UserRepository userRepository;
    private final S3Service s3Service;

    @Transactional
    public Long registerMentorBoard(Long userId, RegisterMentorBoardRequestDto request) {

        User user = this.userRepository.findById(userId)
                                       .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        MentorBoard mentorBoard = this.mentorBoardRepository.save(
                MentorBoard.builder()
                           .title(request.getTitle())
                           .introduce(request.getIntroduce())
                           .category(request.getCategory())
                           .user(user)
                           .build()
        );

        this.faqRepository.saveAll(
                request.getFaqList().stream()
                       .map(e -> Faq.toEntity(e, mentorBoard))
                       .collect(Collectors.toList()));


//        s3Images.stream()
//                .map(s3Service::uploadImage)
//                .map(imageUrl -> MentorImage.builder()
//                                            .mentorBoard(mentorBoard)
//                                            .imageUrl(imageUrl)
//                                            .build())
//                .forEach(this.mentorImageRepository::save);

        return mentorBoard.getId();
    }

    @Transactional(readOnly = true)
    public List<GetMentorBoardResponseDto> getMentorBoardList(Long userId, String category) {

        User user = this.userRepository.findById(userId)
                                       .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        return this.mentorBoardRepository.findAllByUnivAndCategoryOrderByCreatedDateDesc(user.getUniv(), category)
                                         .stream()
                                         .map(GetMentorBoardResponseDto::from)
                                         .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GetMentorBoardDetailResponseDto getMentorBoardDetail(Long boardId) {
        MentorBoard mentorBoard = this.mentorBoardRepository.findById(boardId)
                                                            .orElseThrow(() -> new CustomException(ErrorCode.MENTOR_BOARD_NOT_FOUND));

        List<FaqDto> faqList = this.faqRepository.findAllByMentorBoard(mentorBoard)
                                                 .stream()
                                                 .map(FaqDto::from)
                                                 .collect(Collectors.toList());

        return GetMentorBoardDetailResponseDto.builder()
                                              .boardId(mentorBoard.getId())
                                              .title(mentorBoard.getTitle())
                                              .nickname(mentorBoard.getUser().getNickname())
                                              .introduce(mentorBoard.getIntroduce())
                                              .major(mentorBoard.getUser().getMajor())
                                              .userImageUrl(mentorBoard.getUser().getImageUrl())
                                              .email(mentorBoard.getUser().getEmail())
                                              .faqList(faqList)
                                              .category(mentorBoard.getCategory())
                                              .build();
    }
}

