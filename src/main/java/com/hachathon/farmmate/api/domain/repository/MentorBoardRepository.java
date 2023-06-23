package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.MentorBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorBoardRepository extends JpaRepository<MentorBoard, Long> {
}
