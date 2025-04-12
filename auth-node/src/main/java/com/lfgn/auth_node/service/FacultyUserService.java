package com.lfgn.auth_node.service;

import com.lfgn.auth_node.model.Faculty;
import com.lfgn.auth_node.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacultyUserService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyUserService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Optional<Faculty> findFacultyById(Long id) {
        return facultyRepository.findById(id);
    }

    public Faculty findByUsername(String username) {
        return facultyRepository.findByUsername(username);
    }

}
