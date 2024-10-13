package com.kai.spring_data_jpa_demo.repo;

import com.kai.spring_data_jpa_demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
}
