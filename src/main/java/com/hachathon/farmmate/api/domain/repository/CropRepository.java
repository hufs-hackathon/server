package com.hachathon.farmmate.api.domain.repository;

import com.hachathon.farmmate.api.domain.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop,Long> {
}
