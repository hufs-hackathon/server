package com.hachathon.farmmate.api.domain.entity;

import com.hachathon.farmmate.api.dto.request.JoinRequestDto;
import com.hachathon.farmmate.common.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "major", nullable = false)
    private String major;

    @Column(name = "univ", nullable = false)
    private String univ;

    @Column(name = "role", nullable = false)
    private Integer role;


    public static User ofUser(JoinRequestDto joinRequestDto) {
        return User.builder().imageUrl(joinRequestDto.getImageUrl())
                   .email(joinRequestDto.getEmail())
                   .nickname(joinRequestDto.getNickname())
                   .major(joinRequestDto.getMajor())
                   .univ(joinRequestDto.getUniv())
                   .role(joinRequestDto.getRole())
                   .build();
    }
}
