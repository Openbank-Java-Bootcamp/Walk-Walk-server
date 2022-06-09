package com.ironhack.walkwalkserver.service.impl;

import com.ironhack.walkwalkserver.DTO.ActivityDTO;
import com.ironhack.walkwalkserver.model.Activity;
import com.ironhack.walkwalkserver.model.Dog;
import com.ironhack.walkwalkserver.repository.ActivityRepository;
import com.ironhack.walkwalkserver.repository.DogRepository;
import com.ironhack.walkwalkserver.service.interfaces.ActivityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ActivityService implements ActivityServiceInterface {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private DogRepository dogRepository;

    public Activity findById(Long id){
        return activityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
    }
    public void saveActivity(ActivityDTO activity){
        Activity newActivity = new Activity();
        newActivity.setTitle(activity.getTitle());
        newActivity.setDescription(activity.getDescription());
        newActivity.setCity(activity.getCity());
        newActivity.setDogs(dogRepository.findAllById(activity.getDogsId()));
        activityRepository.save(newActivity);
        List<Dog> dogs = newActivity.getDogs();
        for(Dog dog : dogs){
            List<Activity> activities = dog.getDogActivities();
            activities.add(newActivity);
            dog.setDogActivities(activities);
            dogRepository.save(dog);
        }
    }

    public void update(Long id, ActivityDTO activity){
        Activity activityFromDB = activityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        activityFromDB.setCity(activity.getCity());
        activityFromDB.setTitle(activity.getTitle());
        activityFromDB.setDescription(activity.getDescription());
        activityFromDB.setDogs(dogRepository.findAllById(activity.getDogsId()));
        activityRepository.save(activityFromDB);
    }

    public void deleteActivity(Long id){
        Activity activityFromDB = activityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        activityRepository.deleteById(id);
    }
}
