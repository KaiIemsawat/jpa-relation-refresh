package com.kai.jpa_many2many_demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "course_table")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String abbreviation;
    private int modules;
    private double fee;

    @ManyToMany(
            mappedBy = "courses"
            ,fetch = FetchType.LAZY
    )
    @JsonBackReference
    private List<Student> students;

}
