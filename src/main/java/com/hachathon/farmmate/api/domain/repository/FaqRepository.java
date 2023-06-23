package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.Faq;
import com.hachathon.farmmate.api.domain.entity.MentorBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaqRepository extends JpaRepository<Faq, Long> {

    List<Faq> findAllByMentorBoard(MentorBoard mentorBoard);
}
