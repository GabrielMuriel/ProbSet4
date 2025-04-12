package com.lfgn.grade.model;

import javax.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idgrades;

    @Column(name = "studentID")
    private int studentId;

    @Column(name = "courseID")
    private int courseId;

    @Column(name = "grade")
    private int grade;

    // ✅ No-argument constructor (required by JPA)
    public Grade() {}

    // ✅ Constructor without ID (used when creating new Grade from frontend)
    public Grade(int studentId, int courseId, int grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    // ✅ Optional: Full constructor (if you ever need it)
    public Grade(int idgrades, int studentId, int courseId, int grade) {
        this.idgrades = idgrades;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    // ✅ Getters and Setters
    public int getId() {
        return idgrades;
    }

    public void setId(int idgrades) {
        this.idgrades = idgrades;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
