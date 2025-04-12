package com.lfgn.auth_node.security;

import com.lfgn.auth_node.model.Faculty;
import com.lfgn.auth_node.model.Student;
import com.lfgn.auth_node.repository.FacultyRepository;
import com.lfgn.auth_node.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Try to find the user in Student repository
        Optional<Student> student = Optional.ofNullable(studentRepository.findByUsername(username));

        if (student.isPresent()) {
            Student user = student.get();
            return User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword()) // Ensure the password is hashed
                    .roles("STUDENT") // You can assign roles based on your user type
                    .build();
        }

        // Try to find the user in Faculty repository
        Optional<Faculty> faculty = Optional.ofNullable(facultyRepository.findByUsername(username));

        if (faculty.isPresent()) {
            Faculty user = faculty.get();
            return User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword()) // Ensure the password is hashed
                    .roles("FACULTY") // You can assign roles based on your user type
                    .build();
        }

        // If user not found in either repository
        throw new UsernameNotFoundException("User not found");
    }
}
