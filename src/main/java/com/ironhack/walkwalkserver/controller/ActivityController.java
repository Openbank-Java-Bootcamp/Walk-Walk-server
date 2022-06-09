package com.ironhack.walkwalkserver.controller;

import com.ironhack.walkwalkserver.DTO.ActivityDTO;
import com.ironhack.walkwalkserver.model.Activity;
import com.ironhack.walkwalkserver.repository.ActivityRepository;
import com.ironhack.walkwalkserver.service.impl.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ActivityService activityService;

    @GetMapping("/activities/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Activity getActivityById(@PathVariable(name= "id") Long activityId){
        return activityService.findById(activityId);
    }
    @GetMapping("/activities")
    @ResponseStatus(HttpStatus.OK)
    public List<Activity> getAll(){
        return activityRepository.findAll();
    }

    @PostMapping("/activities")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveActivity(@RequestBody ActivityDTO activity){
        activityService.saveActivity(activity);
    }

    @PutMapping("/activities/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateActivity(@PathVariable Long id, @RequestBody @Valid ActivityDTO activity){
        activityService.update(id, activity);
    }

    @DeleteMapping("/activities/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActivity(@PathVariable Long id){
        activityService.deleteActivity(id);
    }

}
