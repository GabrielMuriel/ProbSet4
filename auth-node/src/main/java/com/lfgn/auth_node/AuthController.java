package com.lfgn.auth_node;

import com.lfgn.auth_node.model.Faculty;
import com.lfgn.auth_node.model.Student;
import com.lfgn.auth_node.model.request.LoginReq;
import com.lfgn.auth_node.repository.FacultyRepository;
import com.lfgn.auth_node.repository.StudentRepository;
import com.lfgn.auth_node.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FacultyRepository facultyRepository;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReq request) {
        // Authenticate user manually
        Student student = studentRepository.findByUsername(request.getUsername());
        if (student != null && student.getPassword().equals(request.getPassword())) {
            String token = jwtUtil.createToken(student);
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }

        Faculty faculty = facultyRepository.findByUsername(request.getUsername());
        if (faculty != null && faculty.getPassword().equals(request.getPassword())) {
            String token = jwtUtil.createToken(faculty);
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

}
