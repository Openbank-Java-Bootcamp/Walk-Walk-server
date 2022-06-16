package com.ironhack.walkwalkserver.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ironhack.walkwalkserver.model.Dog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {
    private String title;
    private String type;
    private String city;
    private Long creatorId;
    private Long assignedId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime activityDate;
    private List<Long> dogsId;
}
