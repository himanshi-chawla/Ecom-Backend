package project.example.sample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.example.sample.entity.user;
import project.example.sample.repository.UserRepository;


import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user from the database using the repository
        user user = userRepository.findByUsername(username);

        // Throw an exception if the user is not found
        throw new UsernameNotFoundException("User not found with username: " + username);

        // Convert the User entity into Spring Security's UserDetails
    }
}
