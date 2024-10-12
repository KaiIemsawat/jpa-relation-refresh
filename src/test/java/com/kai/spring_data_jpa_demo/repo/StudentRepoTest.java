package com.kai.spring_data_jpa_demo.repo;

import com.kai.spring_data_jpa_demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("zukkii@email.com")
                .firstname("Zukkii")
                .lastname("Iem")
                .guardianName("Kai")
                .guardianEmail("kai@email.com")
                .guardianMobile("7778889999")
                .build();

        studentRepo.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepo.findAll();

        for(Student s : studentList) {
            System.out.println(s);
        }
    }
}