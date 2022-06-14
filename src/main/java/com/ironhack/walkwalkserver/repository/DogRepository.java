package com.ironhack.walkwalkserver.repository;

import com.ironhack.walkwalkserver.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
    List<Dog> findByUserId(Long userId);
    List<Dog> findAllByUserId(Long userId);
}
