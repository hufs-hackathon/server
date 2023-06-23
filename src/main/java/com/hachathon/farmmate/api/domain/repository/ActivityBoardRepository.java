package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.ActivityBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityBoardRepository extends JpaRepository<ActivityBoard,Long> {

    @Query("SELECT a From ActivityBoard a WHERE a.univ = :univ ORDER BY a.createdDate DESC")
    List<ActivityBoard> findAllByUnivOrderByCreatedDateDesc(@Param("univ") String univ);
}
