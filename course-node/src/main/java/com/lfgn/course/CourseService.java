package com.lfgn.course;

import com.lfgn.course.model.Course;
import com.lfgn.course.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

//    public String[] getAllCourses() {
//
//        return new String[] {"Math 101", "Science 101"};
//    }
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
