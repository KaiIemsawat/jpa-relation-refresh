package com.kai.spring_data_jpa_demo.repo;

import com.kai.spring_data_jpa_demo.entity.Guardian;
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
//                .guardianName("Kai")
//                .guardianEmail("kai@email.com")
//                .guardianMobile("7778889999")
                .build();

        studentRepo.save(student);
    }

    @Test
    public void  saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("kai@email.com")
                .name("Kai")
                .mobile("7778889999")
                .build();

        Student student = Student.builder()
                .firstname("Titann")
                .lastname("Iem")
                .emailId("titann@email.com")
                .guardian(guardian)
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

    @Test
    public void printStudentsByFirstname() {
        List<Student> studentList = studentRepo.findByFirstname("Zukkii");

        for(Student s : studentList) {
            System.out.println(s);
        }
    }

    @Test
    public void printStudentsByFirstnameContaining() {
        List<Student> studentList = studentRepo.findByFirstnameContaining("tann");

        for(Student s : studentList) {
            System.out.println(s);
        }
    }

    @Test
    public void printStudentsBaseOnGuardianName() {
        List<Student> studentList = studentRepo.findByGuardianName("kai");

        for(Student s : studentList) {
            System.out.println(s);
        }
    }

    @Test
    public void printStudentBaseOnEmailAddress() {
        Student student = studentRepo.findStudentByEmailAddress("zukkii@email.com");

        System.out.println(student);
    }

    @Test
    public void printStudentNameBaseOnEmailAddress() {
         String firstname = studentRepo.findStudentFirstnameByEmailAddress("titann@email.com");

        System.out.println(firstname);
    }

    @Test
    public void printStudentBasedOnLastAndFirstname() {
        List<Student> studentList = studentRepo.findStudentByLastAndFirstname("Iem", "Titann");

        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    @Test
    public void printStudentByEmailAddressUsingNativeQuery() {
        Student student = studentRepo.getStudentByEmailAddressNativeQuery("zukkii@email.com");

        System.out.println(student);
    }
}