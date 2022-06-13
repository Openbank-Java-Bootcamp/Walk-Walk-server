package com.ironhack.walkwalkserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String childFriendly;
    private String energy;
}
