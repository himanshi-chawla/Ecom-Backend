package project.example.sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class user {
    public CharSequence getPassword;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;

    public String getPassword(String encode) {
        return "Password";
    }

    public String getUsername() {
        return "username";
    }

    public String getRole() {
        return "role";
    }

    // Getters and Setters
}

