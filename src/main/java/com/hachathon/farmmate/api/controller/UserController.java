package com.hachathon.farmmate.api.controller;

import com.hachathon.farmmate.api.dto.request.JoinRequestDto;
import com.hachathon.farmmate.api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "[회원 관련 컨트롤러]")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "[회원가입 컨트롤러]")
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinRequestDto joinRequestDto) {
        return ResponseEntity.ok().body(userService.join(joinRequestDto));
    }

}
