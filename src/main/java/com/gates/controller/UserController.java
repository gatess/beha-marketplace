package com.gates.controller;

import com.gates.dao.model.User;
import com.gates.dao.repository.UserRepository;
import com.gates.dto.UserIdentityAvailability;
import com.gates.dto.UserProfile;
import com.gates.dto.UserSummary;
import com.gates.exceptions.ResourceNotFoundException;
import com.gates.security.CurrentUser;
import com.gates.security.UserPrincipal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path="/all")
    public @ResponseBody  Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path="/insert")
    public @ResponseBody  User insertUser() {
        // This returns a JSON or XML with the users
        User user = new User();
        user.setName("GOKHAN");
        //user.setSurname("GTES");
        userRepository.save(user);
        return user;
    }
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username);
        if(user == null) {
        	throw new ResourceNotFoundException("User", "username", username);
        }

        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), null/*user.getCreatedAt()*/);

        return userProfile;
    }
}
