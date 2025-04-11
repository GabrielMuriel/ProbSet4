package com.lfgn.course.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcourses;

    private String courseName;
    private int facultyID;

}