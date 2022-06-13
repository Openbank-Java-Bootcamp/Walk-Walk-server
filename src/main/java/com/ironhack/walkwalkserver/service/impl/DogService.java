package com.ironhack.walkwalkserver.service.impl;

import com.ironhack.walkwalkserver.DTO.DogDTO;
import com.ironhack.walkwalkserver.model.Dog;
import com.ironhack.walkwalkserver.model.User;
import com.ironhack.walkwalkserver.repository.ActivityRepository;
import com.ironhack.walkwalkserver.repository.DogRepository;
import com.ironhack.walkwalkserver.repository.UserRepository;
import com.ironhack.walkwalkserver.service.interfaces.DogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class DogService implements DogServiceInterface {

    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ActivityRepository activityRepository;

    public Dog findById(Long id) {
        return dogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dog not found"));
    }

    public List<Dog> findByUserId(Long userId) {
        return dogRepository.findByUserId(userId);
    }

    public void saveDog(DogDTO dog) {
        Optional<User> user = userRepository.findById(dog.getUserId());
        Dog newDog = new Dog();
        newDog.setName(dog.getName());
        newDog.setSize(dog.getSize());
        newDog.setDogFriendly(dog.getDogFriendly());
        newDog.setCatFriendly(dog.getCatFriendly());
        newDog.setChildFriendly(dog.getChildFriendly());
        newDog.setEnergy(dog.getEnergy());
        newDog.setUser(user.get());
        newDog.setImage(dog.getImage());
        dogRepository.save(newDog);
    }

    public void update(Long id, DogDTO dog) {
        Optional<User> user = userRepository.findById(dog.getUserId());
        Dog dogFromDB = dogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dog not found"));
        dogFromDB.setName(dog.getName());
        dogFromDB.setSize(dog.getSize());
        dogFromDB.setImage(dog.getImage());
        dogFromDB.setDogFriendly(dog.getDogFriendly());
        dogFromDB.setCatFriendly(dog.getCatFriendly());
        dogFromDB.setChildFriendly(dog.getChildFriendly());
        dogFromDB.setEnergy(dog.getEnergy());
        dogFromDB.setUser(user.get());
        dogRepository.save(dogFromDB);
    }

    public void deleteDog(Long id){
        Dog dogFromDB = dogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dog not found"));
        dogRepository.deleteById(id);
    }
}
