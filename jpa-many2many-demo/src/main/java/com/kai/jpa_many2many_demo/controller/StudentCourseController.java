package com.kai.jpa_many2many_demo.controller;

import com.kai.jpa_many2many_demo.entity.Course;
import com.kai.jpa_many2many_demo.entity.Student;
import com.kai.jpa_many2many_demo.repo.CourseRepo;
import com.kai.jpa_many2many_demo.repo.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

    private StudentRepo studentRepo;
    private CourseRepo courseRepo;

    public StudentCourseController(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @PostMapping
    public Student saveStudentWithCourse(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @GetMapping
    public List<Student> findALlStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("/{studentId}")
    public Student findStudentById(@PathVariable Long studentId) {
        return studentRepo.findById(studentId).orElse(null);
    }

    @GetMapping("/find/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name) {
        return studentRepo.findByNameContaining(name);
    }

    @GetMapping("/search/{price}")
    public List<Course> findCourseLessThenPrice(@PathVariable double price) {
        return courseRepo.findByFeeLessThan(price);
    }
}
