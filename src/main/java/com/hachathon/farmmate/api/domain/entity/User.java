package com.hachathon.farmmate.api.domain.entity;

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
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "kakao_id",nullable = false)
    private String kakaoId;

    @Column(name = "nickname",nullable = false)
    private String nickname;

    @Column(name = "phone",nullable = false)
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    private MyPage myPage;
}
