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

    public int getId() {return idgrades;}

    public void setId(int id) {this.idgrades = idgrades;}

    public int getStudentId() {return studentId;}

    public void setStudentId(int studentId) {this.studentId = studentId;}

    public int getCourseId() {return courseId;}

    public void setCourseId(int courseId) {this.courseId = courseId;}

    public int getGrade() {return grade;}

    public void setGrade(int grade) {this.grade = grade;}
}