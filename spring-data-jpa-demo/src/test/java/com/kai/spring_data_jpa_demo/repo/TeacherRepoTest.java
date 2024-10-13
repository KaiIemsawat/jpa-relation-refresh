package com.kai.spring_data_jpa_demo.repo;

import com.kai.spring_data_jpa_demo.entity.Course;
import com.kai.spring_data_jpa_demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepoTest {

    @Autowired
    private TeacherRepo teacherRepo;

    @Test
    public void saveTeacher() {

        Course courseTS = Course.builder()
                .title("Typescript")
                .credit(5)
                .build();

        Course courseJS = Course.builder()
                .title("Javascript")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstname("Stokii")
                .lastname("Hampton")
//                .courses(List.of(courseTS, courseJS))
                .build();

        teacherRepo.save(teacher);
    }
}