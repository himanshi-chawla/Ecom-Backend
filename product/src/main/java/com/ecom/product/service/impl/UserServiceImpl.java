package com.ecom.product.service.impl;

import com.ecom.product.dto.UserDto;
import com.ecom.product.entity.User;
import com.ecom.product.repository.UserRepository;
import com.ecom.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /*
    * This method contains the logic for signing up the new user
    * */
    @Override
    public ResponseEntity<?> signup(UserDto userDto) {
        try {
            //check if email exists, if yes then return UserAlreadyExists message
            if(userRepository.existsByEmail(userDto.getEmail())){
                return new ResponseEntity<>("User already exists!", HttpStatus.BAD_REQUEST);
            }
            User user = mapUserDtoToUser(userDto);
            userRepository.save(user);
            //if not then signup the user i.e. add the user to the database
            return new ResponseEntity<>("User data saved successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while saving user data.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private User mapUserDtoToUser(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
