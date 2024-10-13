package com.kai.spring_data_jpa_demo.repo;

import com.kai.spring_data_jpa_demo.entity.Course;
import com.kai.spring_data_jpa_demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination() {
        Pageable firstPageWithTreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepo.findAll(secondPageWithTwoRecords).getContent();
        long totalElement = courseRepo.findAll(secondPageWithTwoRecords).getTotalElements();
        long totalPage = courseRepo.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("Courses : " + courses);
        System.out.println("Total Elements : " + totalElement);
        System.out.println("Total Pages : " + totalPage);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByCreditDsc = PageRequest.of(0,2, Sort.by("credit").descending());

        Pageable sortBtCreditAsc = PageRequest.of(0,2, Sort.by("credit").ascending());

        List<Course> courses = courseRepo.findAll(sortByTitle).getContent();

        for (Course c : courses) {
            System.out.println(c);
        }
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0,10);
        List<Course> courses = courseRepo.findByTitleContaining("T", firstPageTenRecords).getContent();

        for (Course c : courses) {
            System.out.println(c);
        }
    }
}