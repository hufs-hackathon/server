package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.MentorBoard;
import com.hachathon.farmmate.api.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MentorBoardRepository extends JpaRepository<MentorBoard, Long> {
    @Query("SELECT m FROM MentorBoard m INNER JOIN User u on u.univ = :univ and m.category = :category ORDER BY  m.createdDate DESC")
    List<MentorBoard> findAllByUnivAndCategoryOrderByCreatedDateDesc(@Param("univ") String univ, @Param("category") String category);

    List<MentorBoard> findAllByUser(User user);
}
