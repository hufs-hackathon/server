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
public class ScrapedBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "mentor_board_id", nullable = true)
    private MentorBoard mentorBoard;

    @ManyToOne
    @JoinColumn(name = "mentee_board_id", nullable = true)
    private MenteeBoard menteeBoard;

    @Column(name = "is_scraped")
    private boolean isScraped;
}
