package com.hachathon.farmmate.api.controller;

import com.hachathon.farmmate.api.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class S3Controller {
    private final S3Service s3Service;

    // 그냥 이미지 올리는거 예시로만 만든거...!!!
    @PostMapping("/image")
    public ResponseEntity<String> image(@RequestPart MultipartFile image) {
        String imageUrl = s3Service.uploadImage(image);
        return ResponseEntity.ok().body(imageUrl);
    }
}
