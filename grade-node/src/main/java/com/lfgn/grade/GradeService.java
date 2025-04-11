package com.lfgn.grade;

import com.lfgn.grade.model.Grade;
import com.lfgn.grade.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public void saveGrade(Grade grade) {
        gradeRepository.save(grade);
    }
}