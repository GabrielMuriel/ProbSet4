package com.lfgn.auth_node.model;

import javax.persistence.*;

@Entity
@Table(name = "faculty")
public class Faculty extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfaculty;

    private String name;
    private String username;
    private String password;

    // Getters and setters for specific fields
    public Long getIdfaculty() {
        return idfaculty;
    }

    public void setIdfaculty(Long idfaculty) {
        this.idfaculty = idfaculty;
    }

    @Override
    public String getFirstName() {
        return name; // You can modify this if name is split into first/last name
    }

    @Override
    public String getLastName() {
        return ""; // Optionally extract last name if name is full name
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    // You can add other faculty-specific methods here if necessary
}
