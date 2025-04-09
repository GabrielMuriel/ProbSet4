package com.example.course;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String[] getCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/enroll")
    public String enroll(@RequestBody String courseId) {
        return "Enrolled in course " + courseId;
    }
}
