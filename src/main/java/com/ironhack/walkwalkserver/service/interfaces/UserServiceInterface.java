package com.ironhack.walkwalkserver.service.interfaces;

import com.ironhack.walkwalkserver.model.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User userSignupDTO);

    List<User> getUsers();
}
