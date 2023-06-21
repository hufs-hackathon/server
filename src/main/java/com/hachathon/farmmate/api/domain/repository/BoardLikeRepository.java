package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.BoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardLikeRepository extends JpaRepository<BoardLike,Long> {
}
