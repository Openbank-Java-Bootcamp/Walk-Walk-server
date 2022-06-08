package com.ironhack.walkwalkserver.repository;

import com.ironhack.walkwalkserver.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
