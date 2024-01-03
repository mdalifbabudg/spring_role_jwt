package com.example.springrolejwt.services;

import com.example.springrolejwt.dtos.BearerToken;
import com.example.springrolejwt.dtos.LoginDto;
import com.example.springrolejwt.dtos.RegisterDto;
import com.example.springrolejwt.models.Role;
import com.example.springrolejwt.models.RoleName;
import com.example.springrolejwt.models.User;
import com.example.springrolejwt.repositories.UserRepository;
import com.example.springrolejwt.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IRoleService roleService;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Override
    public String authenticate(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));

        List<String> roleNames = user.getRoles().stream().map(Role::getRoleName).toList();

        return jwtUtils.generateToken(user.getEmail(), roleNames);
    }

    @Override
    public ResponseEntity<?> register(RegisterDto registerDto) {
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken", HttpStatus.SEE_OTHER);
        }

        User user = populateToUser(registerDto, new User());
        saverUser(user);

        String token = jwtUtils.generateToken(registerDto.getEmail(),
                Collections.singletonList(RoleName.USER.toString()));

        return ResponseEntity.ok(new BearerToken(token, "Bearer "));
    }

    @Override
    public User saverUser(User user) {
        return userRepository.save(user);
    }

    private User populateToUser(RegisterDto registerDto, User user) {
        user.setEmail(registerDto.getEmail());
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Role role = roleService.findByRoleName(RoleName.USER);
        user.setRoles(Collections.singletonList(role));

        return user;
    }
}
