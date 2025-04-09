package com.example.course;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

    public String[] getAllCourses() {
        return new String[] {"Math 101", "Science 101"};
    }
}
