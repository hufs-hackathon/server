package com.hachathon.farmmate.api.domain.entity;

import com.hachathon.farmmate.common.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MentorBoard extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "monitor_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content")
    private String introduce;

    @Column(name = "category")
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "mentorBoard", cascade = CascadeType.ALL)
    private List<Faq> faq = new ArrayList<>();

}
