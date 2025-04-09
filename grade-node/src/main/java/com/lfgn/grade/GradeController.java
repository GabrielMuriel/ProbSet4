package com.example.grade;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public String getGrades() {
        return gradeService.getGrades();
    }

    @PostMapping
    public String uploadGrade(@RequestBody Grade grade) {
        return gradeService.uploadGrade(grade);
    }
}
