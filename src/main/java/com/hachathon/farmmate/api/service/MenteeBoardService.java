package com.hachathon.farmmate.api.service;

import com.hachathon.farmmate.api.domain.entity.MenteeBoard;
import com.hachathon.farmmate.api.domain.entity.MenteeImage;
import com.hachathon.farmmate.api.domain.entity.User;
import com.hachathon.farmmate.api.domain.repository.MenteeBoardRepository;
import com.hachathon.farmmate.api.domain.repository.MenteeImageRepository;
import com.hachathon.farmmate.api.domain.repository.UserRepository;
import com.hachathon.farmmate.api.dto.request.RegisterMenteeBoardRequestDto;
import com.hachathon.farmmate.exception.CustomException;
import com.hachathon.farmmate.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenteeBoardService {

    private final MenteeBoardRepository menteeBoardRepository;
    private final MenteeImageRepository menteeImageRepository;
    private final UserRepository userRepository;
    private final S3Service s3Service;

    @Transactional
    public Long registerMenteeBoard(Long userId, RegisterMenteeBoardRequestDto request, List<MultipartFile> s3Images) {

        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        MenteeBoard menteeBoard = this.menteeBoardRepository.save(
                MenteeBoard.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .category(request.getCategory())
                        .user(user)
                        .build()
        );

        s3Images.stream()
                .map(s3Service::uploadImage)
                .map(imageUrl -> MenteeImage.builder()
                        .menteeBoard(menteeBoard)
                        .imageUrl(imageUrl)
                        .build())
                .forEach(this.menteeImageRepository::save);

        return menteeBoard.getId();
    }
}
