package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.MentorBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorBoardRepository extends JpaRepository<MentorBoard, Long> {
    List<MentorBoard> findAllByCategory(String category);
}
