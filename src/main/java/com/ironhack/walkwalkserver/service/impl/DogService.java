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

    public void saveDog(DogDTO dog) {
        Optional<User> user = userRepository.findById(dog.getUserId());
        Dog newDog = new Dog();
        newDog.setName(dog.getName());
        newDog.setDescription(dog.getDescription());
        newDog.setUser(user.get());
        dogRepository.save(newDog);


        /*
        I have to change the structure for DTO
        if(dog.getId() != null) {
            Optional<Dog> optionalDog = dogRepository.findById(dog.getId());
            if(optionalDog.isPresent())
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Dog with id " + dog.getId() + " already exist");
        }
        dogRepository.save(dog);*/
    }

    public void update(Long id, DogDTO dog) {
        Optional<User> user = userRepository.findById(dog.getUserId());
        Dog dogFromDB = dogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dog not found"));
        dogFromDB.setName(dog.getName());
        dogFromDB.setDescription(dog.getDescription());
        dogFromDB.setUser(user.get());
        dogRepository.save(dogFromDB);
    }

    public void deleteDog(Long id){
        Dog dogFromDB = dogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dog not found"));
        dogRepository.deleteById(id);
    }
}
