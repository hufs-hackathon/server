package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.MenteeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenteeBoardRepository extends JpaRepository<MenteeBoard, Long> {
}
