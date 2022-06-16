package com.ironhack.walkwalkserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private double numVotes;
    private double totalScore;
    private double average;
}
