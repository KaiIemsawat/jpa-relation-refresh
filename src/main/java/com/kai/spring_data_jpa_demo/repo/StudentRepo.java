package com.kai.spring_data_jpa_demo.repo;


import com.kai.spring_data_jpa_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    // Native Query Named Param
    @Query(
            value = "SELECT * FROM tbl_student WHERE email_address = :emailAddress",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeQueryNameParam(@Param("emailAddress") String emailAddress);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_student SET firstname = ?1 WHERE email_address = ?2", nativeQuery = true)
    int updateStudentNameByEmail(String firstname, String email); // using int
}
