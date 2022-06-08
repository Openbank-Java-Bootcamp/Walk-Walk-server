package com.ironhack.walkwalkserver.controller;

import com.ironhack.walkwalkserver.DTO.ActivityDTO;
import com.ironhack.walkwalkserver.model.Activity;
import com.ironhack.walkwalkserver.service.impl.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/activity")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveActivity(@RequestBody ActivityDTO activity){
        activityService.saveActivity(activity);
    }
}
