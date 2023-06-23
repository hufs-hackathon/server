package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.MenteeBoard;
import com.hachathon.farmmate.api.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenteeBoardRepository extends JpaRepository<MenteeBoard, Long> {

    @Query("SELECT m FROM MenteeBoard m INNER JOIN User u ON u.univ = :univ AND m.category = :category ORDER BY m.createdDate DESC")
    List<MenteeBoard> findAllByUnivAndCategoryOrderByCreatedDateDesc(@Param("univ") String univ, @Param("category") String category);

    List<MenteeBoard> findAllByUser(User user);
}
