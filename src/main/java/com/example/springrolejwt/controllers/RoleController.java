package com.example.springrolejwt.controllers;

import com.example.springrolejwt.models.Role;
import com.example.springrolejwt.models.RoleName;
import com.example.springrolejwt.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> save(@RequestBody RoleName roleName){
        return ResponseEntity.ok(roleService.save(roleName));
    }
}
