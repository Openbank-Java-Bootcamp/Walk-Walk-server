package com.ironhack.walkwalkserver.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.walkwalkserver.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DogDTO {
    private String name;
    private String description;
    private Long userId;
    private String image;
    private String size;
    private String dogFriendly;
    private String catFriendly;
    private String energy;
}
