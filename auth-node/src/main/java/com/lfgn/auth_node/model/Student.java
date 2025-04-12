package com.lfgn.auth_node.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idstudents;

    private String name;
    private String username;
    private String password;

    // Specific getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdstudents() {
        return idstudents;
    }

    public void setIdstudents(Long idstudents) {
        this.idstudents = idstudents;
    }
}
