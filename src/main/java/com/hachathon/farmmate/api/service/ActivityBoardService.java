package com.hachathon.farmmate.api.service;

import com.hachathon.farmmate.api.domain.entity.ActivityBoard;
import com.hachathon.farmmate.api.domain.entity.User;
import com.hachathon.farmmate.api.domain.repository.ActivityBoardRepository;
import com.hachathon.farmmate.api.domain.repository.UserRepository;
import com.hachathon.farmmate.api.dto.response.ActivityBoardResponseDto;
import com.hachathon.farmmate.api.dto.response.ActivityBoardsResponseDto;
import com.hachathon.farmmate.api.dto.response.SpecificActivityBoardResponseDto;
import com.hachathon.farmmate.exception.CustomException;
import com.hachathon.farmmate.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityBoardService {

    private final ActivityBoardRepository activityBoardRepository;
    private final UserRepository userRepository;

    public List<ActivityBoardsResponseDto> getAllActivityBoards(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND) );
        String univ = user.getUniv();
        List<ActivityBoardsResponseDto> activityBoardsResponseDto = new ArrayList<>();
        List<ActivityBoard> activityBoards = activityBoardRepository.findAllByUnivOrderByCreatedDateDesc(univ);

        Map<String , List<ActivityBoard>> group =activityBoards.stream()
                .collect(Collectors.groupingBy((ActivityBoard::getCategory)));

        group.keySet().stream()
                .forEach(key -> {
                    List<ActivityBoardResponseDto> collect = group.get(key).stream()
                            .map(a -> ActivityBoardResponseDto.builder()
                                    .BoardId(a.getId()).title(a.getTitle()).imageUrl(a.getImageUrl()).tag(a.getTag()).build()).collect(Collectors.toList());
                    activityBoardsResponseDto.add(ActivityBoardsResponseDto.builder().category(key).activityBoardResponseDtoList(collect).build());
                });


        return activityBoardsResponseDto;
    }

    public SpecificActivityBoardResponseDto getSpecificActivityBoard(Long boardId) {
        ActivityBoard activityBoard = activityBoardRepository.findById(boardId).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_POSTING));
        return SpecificActivityBoardResponseDto.builder()
                .title(activityBoard.getTitle())
                .content(activityBoard.getContent())
                .imageUrl(activityBoard.getImageUrl())
                .tag(activityBoard.getTag())
                .build();
    }
}
