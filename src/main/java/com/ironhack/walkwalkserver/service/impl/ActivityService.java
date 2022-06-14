package com.ironhack.walkwalkserver.service.impl;

import com.ironhack.walkwalkserver.DTO.ActivityDTO;
import com.ironhack.walkwalkserver.model.Activity;
import com.ironhack.walkwalkserver.model.Dog;
import com.ironhack.walkwalkserver.model.User;
import com.ironhack.walkwalkserver.repository.ActivityRepository;
import com.ironhack.walkwalkserver.repository.DogRepository;
import com.ironhack.walkwalkserver.repository.UserRepository;
import com.ironhack.walkwalkserver.service.interfaces.ActivityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class ActivityService implements ActivityServiceInterface {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private UserRepository userRepository;

    public Activity findById(Long id){
        return activityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
    }

    public List<Activity> findByCreatorId(Long creatorId) {
        return activityRepository.findByCreatorId(creatorId);
    }
    public List<Activity> findByAssignedId(Long assignedId) {
        return activityRepository.findByAssignedId(assignedId);
    }

    public void saveActivity(ActivityDTO activity){
        Optional<User> creator = userRepository.findById(activity.getCreatorId());
        User assigned = null;
        if(activity.getAssignedId() != null){
            assigned = userRepository.findById(activity.getAssignedId()).get();
        }
        Activity newActivity = new Activity();
        newActivity.setTitle(activity.getTitle());
        newActivity.setType(activity.getType());
        newActivity.setCity(activity.getCity());
        newActivity.setCreator(creator.get());
        newActivity.setAssigned(assigned);
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
        Optional<User> creator = userRepository.findById(activity.getCreatorId());
        User assigned = null;
        if(activity.getAssignedId() != null){
            assigned = userRepository.findById(activity.getAssignedId()).get();
        }
        Activity activityFromDB = activityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        activityFromDB.setCity(activity.getCity());
        activityFromDB.setTitle(activity.getTitle());
        activityFromDB.setType(activity.getType());
        activityFromDB.setCreator(creator.get());
        activityFromDB.setAssigned(assigned);
        activityFromDB.setDogs(dogRepository.findAllById(activity.getDogsId()));
        activityRepository.save(activityFromDB);
    }

    public void deleteActivity(Long id){
        Activity activityFromDB = activityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
        activityRepository.deleteById(id);
    }
}
