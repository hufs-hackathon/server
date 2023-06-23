package com.hachathon.farmmate.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    FAIL_IMAGE_UPLOAD(INTERNAL_SERVER_ERROR, "이미지 업로드에 실패했습니다."),
    NOT_FOUND_POSTING(NOT_FOUND, "해당 포스팅이 없습니다."),
    DUPLICATE_RESOURCE(CONFLICT, "데이터가 이미 존재합니다"),
    USER_NOT_FOUND(NOT_FOUND, "해당 회원이 존재하지 않습니다."),
    NECESSARY_JOIN(ACCEPTED, "회원가입이 필요합니다."),
    MENTOR_BOARD_NOT_FOUND(NOT_FOUND, "해당 멘토 게시글이 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
