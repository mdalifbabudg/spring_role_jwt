package com.example.springrolejwt.services;

import com.example.springrolejwt.models.Role;
import com.example.springrolejwt.models.RoleName;

public interface IRoleService {
    Role save(RoleName roleName);

    Role findByRoleName(RoleName roleName);
}
