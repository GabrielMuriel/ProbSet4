package com.lfgn.auth_node.repository;

import com.lfgn.auth_node.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByUsername(String username);
}
