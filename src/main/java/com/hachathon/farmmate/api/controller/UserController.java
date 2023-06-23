package com.hachathon.farmmate.api.controller;

import com.hachathon.farmmate.api.dto.request.JoinRequestDto;
import com.hachathon.farmmate.api.dto.response.MypageResponseDto;
import com.hachathon.farmmate.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinRequestDto joinRequestDto) {
        return ResponseEntity.ok().body(userService.join(joinRequestDto));
    }

    @GetMapping("/mypage")
    public ResponseEntity<MypageResponseDto> mypage(@RequestParam Long userId) {
        return ResponseEntity.ok().body(userService.mypage(userId));
    }

}
