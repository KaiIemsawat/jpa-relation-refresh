package com.kai.jpa_many2many_demo.repo;

import com.kai.jpa_many2many_demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    List<Course> findByFeeLessThan(double fee);
}
