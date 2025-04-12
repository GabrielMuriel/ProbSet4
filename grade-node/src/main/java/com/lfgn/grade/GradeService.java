package com.lfgn.grade;

import com.lfgn.grade.model.Grade;
import com.lfgn.grade.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Grade saveGrade(Grade grade) {
        gradeRepository.save(grade);
        return grade;
    }

    // Fix: Added this method to fetch a grade by its ID
    public Grade getGradeById(int id) {
        return gradeRepository.findById(id).orElse(null); // This fetches the grade or returns null if not found
    }

    // Fix: Added method to delete a grade by its ID
    public void deleteGrade(int id) {
        gradeRepository.deleteById(id);  // This deletes the grade by its ID
    }
}
