package com.example.frontendnode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping("/")
    public String home() {
        return "index";  // Thymeleaf will look for an index.html file in the resources/templates folder
    }
}
