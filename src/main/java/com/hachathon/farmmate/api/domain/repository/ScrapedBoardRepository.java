package com.hachathon.farmmate.api.domain.repository;


import com.hachathon.farmmate.api.domain.entity.ScrapedBoard;
import com.hachathon.farmmate.api.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScrapedBoardRepository extends JpaRepository<ScrapedBoard, Long> {
    Optional<ScrapedBoard> findByUserAndBoardId(User user, Long boardId);

    List<ScrapedBoard> findByUser(User user);
}
