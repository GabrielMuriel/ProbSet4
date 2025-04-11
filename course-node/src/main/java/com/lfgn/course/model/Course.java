package com.lfgn.course.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcourses;

    @Column(name = "coursename")
    private String courseName;
    @Column(name = "facultyID")
    private int facultyID;

    public int getIdcourses() {
        return idcourses;
    }

    public void setIdcourses(int idcourses) {
        this.idcourses = idcourses;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }
}