package com.ironhack.walkwalkserver.controller;

import com.ironhack.walkwalkserver.DTO.DogDTO;
import com.ironhack.walkwalkserver.model.Dog;
import com.ironhack.walkwalkserver.repository.DogRepository;
import com.ironhack.walkwalkserver.service.impl.DogService;
import com.ironhack.walkwalkserver.service.interfaces.DogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DogController {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private DogService dogService;


    @GetMapping("/dogs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dog getDogById(@PathVariable(name= "id") Long dogId) {
        return dogService.findById(dogId);
    }

    @GetMapping("/mydogs/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Dog> getDogByUserId(@PathVariable(name= "userId") Long userId) {
        return dogService.findByUserId(userId);
    }

    @GetMapping("/dogs")
    @ResponseStatus(HttpStatus.OK)
    public List<Dog> getAll() {
        return dogRepository.findAll();
    }

    @PostMapping("/dogs")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDog(@RequestBody @Valid DogDTO dog){
        dogService.saveDog(dog);
    }

    @PutMapping("/dogs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDog(@PathVariable Long id, @RequestBody @Valid DogDTO dog){
        dogService.update(id, dog);
    }

    @DeleteMapping("/dogs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDog(@PathVariable Long id){
        dogService.deleteDog(id);
    }
}
