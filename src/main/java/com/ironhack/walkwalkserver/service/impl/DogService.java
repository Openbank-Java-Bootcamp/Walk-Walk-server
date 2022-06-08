package com.ironhack.walkwalkserver.service.impl;

import com.ironhack.walkwalkserver.model.Dog;
import com.ironhack.walkwalkserver.repository.DogRepository;
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

    public Dog findById(Long id) {
        return dogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dog not found"));
    }

    public void saveDog(Dog dog) {
        if(dog.getId() != null) {
            Optional<Dog> optionalDog = dogRepository.findById(dog.getId());
            if(optionalDog.isPresent())
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Dog with id " + dog.getId() + " already exist");
        }
        dogRepository.save(dog);
    }

    public void update(Long id, Dog dog) {
        Dog dogFromDB = dogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dog not found"));
    }

    public void deleteDog(Long id){
        Dog dogFromDB = dogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dog not found"));
        dogRepository.deleteById(id);
    }
}
