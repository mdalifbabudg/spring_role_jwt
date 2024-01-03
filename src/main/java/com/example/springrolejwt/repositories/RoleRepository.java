package com.example.springrolejwt.repositories;

import com.example.springrolejwt.models.Role;
import com.example.springrolejwt.models.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(RoleName roleName);
}
