package com.ecom.product.service;

import com.ecom.product.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    ResponseEntity<?> signup(UserDto userDto);
}
