package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
