package com.ironhack.walkwalkserver.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityWithoutDogsDTO {
    private String title;
    private String type;
    private String city;
    private Long creatorId;
    private Long assignedId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime activityDate;
    private boolean isChosen = false;

}