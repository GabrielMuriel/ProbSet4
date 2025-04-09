package com.example.grade;

import org.springframework.stereotype.Service;

@Service
public class GradeService {

    public String getGrades() {
        return "Math: A, Science: B+";
    }

    public String uploadGrade(Grade grade) {
        return "Grade uploaded: " + grade.getCourse() + " - " + grade.getGrade();
    }
}
