package project.example.sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.example.sample.entity.user;
import project.example.sample.repository.UserRepository;

public class UserService {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(user user) {
        user.getPassword(passwordEncoder.encode(user.getPassword(passwordEncoder.encode(user.getPassword))));
        UserRepository.save(user);
    }
}
