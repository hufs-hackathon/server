package com.hachathon.farmmate.api.domain.repository;


import com.hachathon.farmmate.api.domain.entity.ScrapedBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScrapedBoardRepository extends JpaRepository<ScrapedBoard, Long> {
}
