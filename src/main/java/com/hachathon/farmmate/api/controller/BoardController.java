package com.hachathon.farmmate.api.controller;

import com.hachathon.farmmate.api.dto.request.RegisterMenteeBoardRequestDto;
import com.hachathon.farmmate.api.dto.request.RegisterMentorBoardRequestDto;
import com.hachathon.farmmate.api.dto.response.*;
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
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "[게시글 관련 컨트롤러]")
@RequestMapping("/univlinker")
public class BoardController {

    private final MentorBoardService mentorBoardService;
    private final MenteeBoardService menteeBoardService;
    private final ActivityBoardService activityBoardService;

    @Operation(summary = "[멘토 게시글 저장 컨트롤러]")
    @PostMapping("/mentor")
    public ResponseEntity<Long> registerMentorBoard(
            @RequestParam(value = "userId") Long userId,
            @Valid @RequestPart RegisterMentorBoardRequestDto request
    ) {
        return new ResponseEntity<>(
                this.mentorBoardService.registerMentorBoard(userId, request), HttpStatus.CREATED);
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

    @GetMapping("/board/all")
    public ResponseEntity<List<ActivityBoardsResponseDto>> getAllActivityBoards(@RequestParam(value = "userId") Long userId) {
        return ResponseEntity.ok().body(activityBoardService.getAllActivityBoards(userId));
    }


    @GetMapping("/board")
    public ResponseEntity<SpecificActivityBoardResponseDto> getSpecificActivityBoard(@RequestParam(value = "boardId") Long boardId) {
        return ResponseEntity.ok().body(activityBoardService.getSpecificActivityBoard(boardId));
    }

    @Operation(summary = "[멘토 게시글 조회 컨트롤러]")
    @GetMapping("/mentor/all")
    public ResponseEntity<List<GetMentorBoardResponseDto>> getMentorBoardList(
            @NotBlank @RequestParam(name = "category") String category
    ) {
        return new ResponseEntity<>(
                this.mentorBoardService.getMentorBoardList(category), HttpStatus.OK);

    }

    @Operation(summary = "[멘토 게시글 상세 조회 컨트롤러]")
    @GetMapping("/mentor/{boardId}")
    public ResponseEntity<GetMentorBoardDetailResponseDto> getMentorBoardDetail(
            @PathVariable(value = "boardId") Long boardId
    ) {
        return new ResponseEntity<>(
                this.mentorBoardService.getMentorBoardDetail(boardId), HttpStatus.OK);
    }

    @GetMapping("/mentee/all")
    public ResponseEntity<List<MenteeBoardsResponseDto>> getAllMenteeBoards(
            @RequestParam(value = "userId") Long userId,
            @RequestParam(value = "category") String category) {
        return ResponseEntity.ok().body(menteeBoardService.getAllMenteeBoards(userId, category));
    }

    @GetMapping("/mentee")
    public ResponseEntity<MenteeBoardResponseDto> getSpecificMenteeBoard(
            @RequestParam(value = "boardId") Long boardId,
            @RequestParam(value = "userId") Long userId) {
        return ResponseEntity.ok().body(menteeBoardService.getSpecificMenteeBoard(userId, boardId));
    }

}
