package com.lfgn.auth_node.repository;

import com.lfgn.auth_node.model.Faculty;
import com.lfgn.auth_node.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUsername(String username);
}
