package com.hachathon.farmmate.api.controller;

import com.hachathon.farmmate.api.dto.request.JoinRequestDto;
import com.hachathon.farmmate.api.dto.request.LoginRequestDto;
import com.hachathon.farmmate.api.dto.response.GetMentorBoardResponseDto;
import com.hachathon.farmmate.api.dto.response.MyPageScrapedResponseDto;
import com.hachathon.farmmate.api.dto.response.MypageResponseDto;
import com.hachathon.farmmate.api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "[회원 관련 컨트롤러]")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "[로그인 컨트롤러]")
    @PostMapping("/login")
    public ResponseEntity<Long> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok().body(userService.login(loginRequestDto));
    }

    @Operation(summary = "[회원가입 컨트롤러]")
    @PostMapping("/join")
    public ResponseEntity<Long> join(@RequestBody JoinRequestDto joinRequestDto) {
        return ResponseEntity.ok().body(userService.join(joinRequestDto));
    }

    @Operation(summary = "[마이페이지 조회 컨트롤러]")
    @GetMapping("/mypage")
    public ResponseEntity<MypageResponseDto> mypage(@RequestParam Long userId) {
        return ResponseEntity.ok().body(userService.mypage(userId));
    }

    @Operation(summary = "[마이페이지 내가 쓴 글 조회 컨트롤러]")
    @GetMapping("/mypage/{userId}/post")
    public ResponseEntity<List<GetMentorBoardResponseDto>> getMyPost(
            @PathVariable(name = "userId") Long userId
    ) {
        return ResponseEntity.ok().body(userService.getMyPost(userId));
    }

    @Operation(summary = "[스크랩 조회]")
    @GetMapping("/mypage/board/scrap")
    public ResponseEntity<List<MyPageScrapedResponseDto>> getMyScrapResult(
            @RequestParam(value = "userId", required = false) Long userId
    ) {
        return ResponseEntity.ok().body(userService.getMyScrapResult(userId));
    }
}
