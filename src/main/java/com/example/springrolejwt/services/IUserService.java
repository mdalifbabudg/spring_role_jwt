package com.example.springrolejwt.services;

import com.example.springrolejwt.dtos.LoginDto;
import com.example.springrolejwt.dtos.RegisterDto;
import com.example.springrolejwt.models.Role;
import com.example.springrolejwt.models.User;
import org.springframework.http.ResponseEntity;


public interface IUserService {
    String authenticate(LoginDto loginDto);
    ResponseEntity<?> register (RegisterDto registerDto);
    User saverUser (User user) ;
}
