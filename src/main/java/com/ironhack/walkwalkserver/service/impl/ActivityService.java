package com.ironhack.walkwalkserver.service.impl;

import com.ironhack.walkwalkserver.DTO.ActivityDTO;
import com.ironhack.walkwalkserver.model.Activity;
import com.ironhack.walkwalkserver.repository.ActivityRepository;
import com.ironhack.walkwalkserver.repository.DogRepository;
import com.ironhack.walkwalkserver.service.interfaces.ActivityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService implements ActivityServiceInterface {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private DogRepository dogRepository;

    public void saveActivity(ActivityDTO activity){
        Activity newActivity = new Activity();
        newActivity.setTitle(activity.getTitle());
        newActivity.setDescription(activity.getDescription());
        newActivity.setDogs(dogRepository.findAllById(activity.getDogsId()));
        activityRepository.save(newActivity);
    }
}
