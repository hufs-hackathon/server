package com.hachathon.farmmate.api.controller;

import com.hachathon.farmmate.api.dto.request.RegisterMenteeBoardRequestDto;
import com.hachathon.farmmate.api.dto.request.RegisterMentorBoardRequestDto;
import com.hachathon.farmmate.api.dto.response.ActivityBoardsResponseDto;
import com.hachathon.farmmate.api.service.ActivityBoardService;
import com.hachathon.farmmate.api.service.MenteeBoardService;
import com.hachathon.farmmate.api.service.MentorBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "[게시글 관련 컨트롤러]")
@RequestMapping("/univlinker")
public class BoardController {

    private final MentorBoardService mentorBoardService;
    private final MenteeBoardService menteeBoardService;

    @Operation(summary = "[멘토 게시글 저장 컨트롤러]")
    @PostMapping("/mentor")
    public ResponseEntity<Void> registerMentorBoard(
            @RequestParam(value = "userId") Long userId,
            @Valid @RequestPart RegisterMentorBoardRequestDto request,
            @RequestPart("s3Images") List<MultipartFile> s3Images
    ) {
        this.mentorBoardService.registerMentorBoard(userId, request, s3Images);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "[멘티 게시글 저장 컨트롤러]")
    @PostMapping("/mentee")
    public ResponseEntity<Long> registerMenteeBoard(
            @RequestParam(value = "userId") Long userId,
            @Valid @RequestPart RegisterMenteeBoardRequestDto request,
            @RequestPart List<MultipartFile> s3Images
    ) {
        return new ResponseEntity<>(
                this.menteeBoardService.registerMenteeBoard(userId, request, s3Images), HttpStatus.CREATED);
    }

    private final ActivityBoardService activityBoardService;

    @GetMapping("/board/all")
    public ResponseEntity<List<ActivityBoardsResponseDto>> getAllActivityBoards(@RequestParam(value = "userId") Long userId) {
        return ResponseEntity.ok().body(activityBoardService.getAllActivityBoards(userId));
    }
}
