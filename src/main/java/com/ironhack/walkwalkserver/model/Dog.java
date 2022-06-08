package com.ironhack.walkwalkserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    @JoinTable(
            name = "dog_activities",
            joinColumns = @JoinColumn(name = "dog_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private List<Activity> dogActivities;
}
