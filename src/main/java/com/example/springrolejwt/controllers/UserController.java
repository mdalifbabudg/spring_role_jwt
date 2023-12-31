package com.example.springrolejwt.controllers;

import com.example.springrolejwt.dtos.LoginDto;
import com.example.springrolejwt.dtos.RegisterDto;
import com.example.springrolejwt.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService iUserService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
        return iUserService.register(registerDto);
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody LoginDto loginDto) {
        return iUserService.authenticate(loginDto);
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "bye";
    }
}