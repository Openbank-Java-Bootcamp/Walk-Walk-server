package com.ironhack.walkwalkserver.service.impl;



import com.ironhack.walkwalkserver.model.User;
import com.ironhack.walkwalkserver.repository.RoleRepository;
import com.ironhack.walkwalkserver.repository.UserRepository;
import com.ironhack.walkwalkserver.service.interfaces.UserServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements UserServiceInterface, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public User saveUser(User userSignupDTO) {
        log.info("Saving a new user {} inside of the database", userSignupDTO.getUsername());
        User user = new User(userSignupDTO.getUsername(), userSignupDTO.getEmail(), userSignupDTO.getPassword(), userSignupDTO.getNumber());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User is found in the database: {}", email);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);

        }
    }

    /*public void update(Long id, int rating) {

        User userFromDB = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        userFromDB.getRating().setNumVotes(userFromDB.getRating().getNumVotes()+1);
        userFromDB.getRating().setTotalScore(userFromDB.getRating().getTotalScore()+rating);
        userFromDB.getRating().setAverage(userFromDB.getRating().getTotalScore() / userFromDB.getRating().getNumVotes());

        userRepository.save(userFromDB);
    }*/
}
