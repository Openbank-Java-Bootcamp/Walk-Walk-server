package com.ironhack.walkwalkserver.model;


import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Provide a username.")
    private String username;
    @Pattern(regexp = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9]"
            + "(?:[A-Za-z0-9-]*[A-Za-z0-9])?",
            message = "Provide a valid email address.")
    private String email;

    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}",
            message = "Password must have at least 6 characters and contain at least one number, one lowercase and one uppercase letter.")
    private String password;

    @Pattern(regexp = "^[0-9]{9}$",
            message = "Provide a valid phone number.")
    private String number;

    /*@Embedded
    private Rating rating= new Rating(0,0,0);*/

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Dog> dogs;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();



    public User(String username, String email, String password, String number) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.number = number;
    }
}
