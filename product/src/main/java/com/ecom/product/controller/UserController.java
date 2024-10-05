package com.ecom.product.controller;

import com.ecom.product.dto.UserDto;
import com.ecom.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/signup")
    public ResponseEntity<?> signup(@RequestBody UserDto userDto){
        // invoke the service methods to implement logic to signup the user i.e. add the user
        // to the database
        ResponseEntity<?> response = userService.signup((userDto));
        return new ResponseEntity<>(response,response.getStatusCode());
    }

    //similarly add an api "/api/login" for login endpoint

}
