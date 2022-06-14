package com.ironhack.walkwalkserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityWithoutDogsDTO {
    private String title;
    private String type;
    private String city;
    private Long creatorId;
    private Long assignedId;

}