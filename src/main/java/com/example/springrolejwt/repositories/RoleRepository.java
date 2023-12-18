package com.example.springrolejwt.repositories;

import com.example.springrolejwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
