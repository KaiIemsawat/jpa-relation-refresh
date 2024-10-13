package com.kai.spring_data_jpa_demo.repo;

import com.kai.spring_data_jpa_demo.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepo extends JpaRepository<CourseMaterial, Long> {
}

