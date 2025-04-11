package com.lfgn.grade;

import com.lfgn.grade.model.Grade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") @RestController @RequestMapping("/grades") public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<Grade> getGrades() {
        return gradeService.getAllGrades();
    }

    @PostMapping("/add")
    public String addGrade(@RequestBody Grade grade) {
        gradeService.saveGrade(grade);
        return "Grade added.";
    }
}