package com.ironhack.walkwalkserver.service.interfaces;

import com.ironhack.walkwalkserver.model.Role;

public interface RoleServiceInterface {

    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);
}
