package com.lfgn.course;

import com.lfgn.course.model.Course;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses() {
         return courseService.getAllCourses();
    }

    @PostMapping("/enroll")
    public String enroll(@RequestBody String courseId) {
        return "Enrolled in course " + courseId;
    }
}
