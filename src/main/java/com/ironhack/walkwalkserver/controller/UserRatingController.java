package com.ironhack.walkwalkserver.controller;


import com.ironhack.walkwalkserver.DTO.DogDTO;
import com.ironhack.walkwalkserver.model.Dog;
import com.ironhack.walkwalkserver.model.User;
import com.ironhack.walkwalkserver.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserRatingController {
    @Autowired
    private UserService userService;

    /*@PutMapping("/ratings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserRating(@PathVariable Long id, @RequestBody @Valid int rating){
        userService.update(id, rating);
    }*/


}
