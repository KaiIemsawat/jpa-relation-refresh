package com.kai.spring_data_jpa_demo.repo;

import com.kai.spring_data_jpa_demo.entity.Course;
import com.kai.spring_data_jpa_demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepoTest {

    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepo.findAll();

        for(Course c : courses) {
            System.out.println("COURSE : " + courses);
        }
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstname("Kinkin")
                .lastname("Iem")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepo.save(course);
    }
}