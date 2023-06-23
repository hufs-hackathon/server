package com.hachathon.farmmate.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    FAIL_IMAGE_UPLOAD(INTERNAL_SERVER_ERROR,"이미지 업로드에 실패했습니다."),
    NOT_FOUND_POSTING(BAD_REQUEST, "해당 포스팅이 없습니다."),
    DUPLICATE_RESOURCE(CONFLICT, "데이터가 이미 존재합니다");

    private final HttpStatus httpStatus;
    private final String message;
}
