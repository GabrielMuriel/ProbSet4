package com.lfgn.auth_node.service;

import com.lfgn.auth_node.model.Faculty;
import com.lfgn.auth_node.model.Student;
import com.lfgn.auth_node.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentUserService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentUserService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

}
