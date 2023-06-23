package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.ActivityBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityBoardRepository extends JpaRepository<ActivityBoard,Long> {
}
