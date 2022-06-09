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
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String city;
    @JsonIgnore
    @ManyToMany(mappedBy = "dogActivities",  fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Dog> dogs;
}
