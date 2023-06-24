//package com.hachathon.farmmate.api.domain.repository;
//
//import com.hachathon.farmmate.api.domain.entity.MenteeBoard;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface MenteeImageRepository extends JpaRepository<MenteeImage, Long> {
//    @Query("SELECT m FROM MenteeImage m WHERE m.menteeBoard = :menteeBoard")
//    List<MenteeImage> findByMenteeBoard(@Param("menteeBoard") MenteeBoard menteeBoard);
//}
