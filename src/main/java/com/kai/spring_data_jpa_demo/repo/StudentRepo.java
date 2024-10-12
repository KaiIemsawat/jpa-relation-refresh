package com.kai.spring_data_jpa_demo.repo;


import com.kai.spring_data_jpa_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    List<Student> findByFirstname(String firstname);

    List<Student> findByFirstnameContaining(String partOfName); // findBy...Containing is a build-in keyword

    List<String> findByLastnameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstnameAndLastname(String fName, String lName);

    // JPQL
    @Query("SELECT s FROM Student s WHERE s.emailId = ?1")
    Student findStudentByEmailAddress(String emailId);

    @Query("SELECT s.firstname FROM Student s WHERE s.emailId = ?1")
        // firstname or emailId must match to variable name from Entity
    String findStudentFirstnameByEmailAddress(String emailId);

    @Query("SELECT s FROM Student s WHERE s.lastname = ?1 AND s.firstname = ?2")
    List<Student> findStudentByLastAndFirstname(String lastname, String firstname);

    // Native Query
    @Query(
            value = "SELECT * FROM tbl_student WHERE email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeQuery(String emailAddress);
}
