package project.example.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";  // Return login page view
    }

    @GetMapping("/home")
    public String home() {
        return "home";  // Return home page after successful login
    }
}
