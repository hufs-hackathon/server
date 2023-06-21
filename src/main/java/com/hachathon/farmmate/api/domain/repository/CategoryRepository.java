package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
