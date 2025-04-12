package com.lfgn.grade;

import com.lfgn.grade.model.Grade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") @RestController @RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;
    private static final Logger logger = LoggerFactory.getLogger(GradeController.class);

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<Grade> getGrades() {
        return gradeService.getAllGrades();
    }

//    @PostMapping("/add")
//    public String addGrade(@RequestBody Grade grade) {
//        gradeService.saveGrade(grade);
//        System.out.println(grade);
//        return "Grade added.";
//    }

    @PostMapping("/add")
    public ResponseEntity<?> addGrade(@RequestBody Grade grade) {
        try {
            // Log the received grade object
            logger.info("Received grade: studentId={}, courseId={}, grade={}",
                    grade.getStudentId(), grade.getCourseId(), grade.getGrade());

            Grade savedGrade = gradeService.saveGrade(grade);
            return ResponseEntity.ok(savedGrade);
        } catch (Exception e) {
            logger.error("Error saving grade", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving grade: " + e.getMessage());
        }
    }

    // Fix: Added the endpoint for updating grades.
    @PutMapping("/edit/{id}")  // Added this new endpoint
    public String editGrade(@PathVariable int id, @RequestBody Grade grade) {
        Grade existingGrade = gradeService.getGradeById(id);
        if (existingGrade != null) {
            existingGrade.setGrade(grade.getGrade());
            existingGrade.setCourseId(grade.getCourseId());
            existingGrade.setStudentId(grade.getStudentId());
            gradeService.saveGrade(existingGrade);
            return "Grade updated.";
        }
        return "Grade not found.";
    }

    // Fix: Added the endpoint for deleting grades.
    @DeleteMapping("/delete/{id}") // Added this new endpoint
    public String deleteGrade(@PathVariable int id) {
        gradeService.deleteGrade(id);
        return "Grade deleted.";
    }
}
