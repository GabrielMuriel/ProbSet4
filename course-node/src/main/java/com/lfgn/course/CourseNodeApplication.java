package com.lfgn.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.lfgn.course.repository")  // Enables scanning of repositories
//@EntityScan(basePackages = "com.lfgn.course.model")  // Enables scanning of model entities
public class CourseNodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseNodeApplication.class, args);
	}

}
