package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.MyPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyPageRepository extends JpaRepository<MyPage,Long> {
}
