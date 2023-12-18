package com.example.springrolejwt.services;

import com.example.springrolejwt.models.Role;
import com.example.springrolejwt.models.RoleName;
import com.example.springrolejwt.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService{

    private final RoleRepository roleRepository;

    @Override
    public Role save(RoleName roleName) {
        return roleRepository.save(new Role(roleName));
    }
}
