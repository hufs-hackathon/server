package com.hachathon.farmmate.api.domain.entity;

import com.hachathon.farmmate.api.dto.response.FaqDto;
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
public class Faq {

    @Id
    @GeneratedValue
    @Column(name = "faq_id")
    private Long id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "answer", nullable = false)
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id")
    private MentorBoard mentorBoard;

    public static Faq toEntity(FaqDto dto, MentorBoard mentorBoard) {
        return Faq.builder()
                  .question(dto.getQuestion())
                  .answer(dto.getAnswer())
                  .mentorBoard(mentorBoard)
                  .build();
    }
}
