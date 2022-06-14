package com.ironhack.walkwalkserver.repository;

import com.ironhack.walkwalkserver.model.Activity;
import com.ironhack.walkwalkserver.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByCreatorId(Long creatorId);
    List<Activity> findByAssignedId(Long assignedId);
}
