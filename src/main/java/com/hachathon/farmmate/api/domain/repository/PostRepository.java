package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Board,Long> {
}
