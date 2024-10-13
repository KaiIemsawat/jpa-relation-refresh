package com.kai.jpa_many2many_demo.repo;

import com.kai.jpa_many2many_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    List<Student> findByNameContaining(String name);
}
