package com.ironhack.walkwalkserver.DTO;

import com.ironhack.walkwalkserver.model.Dog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {
    private Long id;
    private String title;
    private String description;
    private List<Long> dogsId;
}
