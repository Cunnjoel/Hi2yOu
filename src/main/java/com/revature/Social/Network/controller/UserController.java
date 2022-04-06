package com.revature.Social.Network.controller;

import com.revature.Social.Network.models.User;
import com.revature.Social.Network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser(){
        return this.userService.getAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return  userService.createUser(user);
    }


    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);

        return "the user with the id" + userId + "was successfully deleted";
    }

    @GetMapping("{username/{username}}")
    public User getUserGivenUsername(@PathVariable String username){
        return this.userService.getUserGivenUsername(username);
    }
}
