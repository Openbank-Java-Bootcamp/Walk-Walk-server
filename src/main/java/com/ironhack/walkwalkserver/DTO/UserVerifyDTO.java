package com.ironhack.walkwalkserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVerifyDTO {
    private String id;
    private String username;
}
