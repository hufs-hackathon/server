package com.hachathon.farmmate.api.service;

import com.hachathon.farmmate.api.domain.entity.MentorBoard;
import com.hachathon.farmmate.api.domain.entity.MentorImage;
import com.hachathon.farmmate.api.domain.entity.User;
import com.hachathon.farmmate.api.domain.repository.MentorBoardRepository;
import com.hachathon.farmmate.api.domain.repository.MentorImageRepository;
import com.hachathon.farmmate.api.domain.repository.UserRepository;
import com.hachathon.farmmate.api.dto.request.RegisterMentorBoardRequestDto;
import com.hachathon.farmmate.api.dto.response.GetMentorBoardResponseDto;
import com.hachathon.farmmate.exception.CustomException;
import com.hachathon.farmmate.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MentorBoardService {

    private final MentorBoardRepository mentorBoardRepository;
    private final MentorImageRepository mentorImageRepository;
    private final UserRepository userRepository;
    private final S3Service s3Service;

    @Transactional
    public void registerMentorBoard(Long userId, RegisterMentorBoardRequestDto request, List<MultipartFile> s3Images) {

        User user = this.userRepository.findById(userId)
                                       .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));


        MentorBoard mentorBoard = this.mentorBoardRepository.save(
                MentorBoard.builder()
                           .title(request.getTitle())
                           .content(request.getContent())
                           .category(request.getCategory())
                           .user(user)
                           .build()
        );

        s3Images.stream()
                .map(s3Service::uploadImage)
                .map(imageUrl -> MentorImage.builder()
                                            .mentorBoard(mentorBoard)
                                            .imageUrl(imageUrl)
                                            .build())
                .forEach(this.mentorImageRepository::save);
    }

    @Transactional(readOnly = true)
    public List<GetMentorBoardResponseDto> getMentorBoardList(String category) {
        return this.mentorBoardRepository.findAllByCategory(category)
                                         .stream()
                                         .map(GetMentorBoardResponseDto::from)
                                         .collect(Collectors.toList());
    }
}

