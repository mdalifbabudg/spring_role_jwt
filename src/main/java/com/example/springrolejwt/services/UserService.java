package com.example.springrolejwt.services;

import com.example.springrolejwt.dtos.LoginDto;
import com.example.springrolejwt.dtos.RegisterDto;
import com.example.springrolejwt.models.Role;
import com.example.springrolejwt.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Override
    public String authenticate(LoginDto loginDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> register(RegisterDto registerDto) {
        return null;
    }

    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public User saverUser(User user) {
        return null;
    }
}
