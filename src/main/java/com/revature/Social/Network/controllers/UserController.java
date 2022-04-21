package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.User;
import com.revature.Social.Network.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
public class UserController {
    Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
    }

    @GetMapping
    public List<User> getAllUser(){
        return this.userService.getAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user)
    {
        try
        {
            return userService.createUser(user);
        }
        catch (Exception e)
        {
            logger.warn("Stack Trace?", e);
            return new User();
        }
    }



    @PutMapping
    public User updateUser(@RequestBody User user)
    {
        try
        {
            return userService.updateUser(user);
        }catch (Exception e){

            logger.warn("Stack Trace?", e);
            return new User();
        }
    }
    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable Integer userId){
        try
        {
            userService.deleteUser(userId);
            return "the user with the id" + userId + "was successfully deleted";
        }
        catch(Exception e)
        {
            logger.warn("Stack Trace?", e);
            return "Couldn't find user to delete";
        }

    }


    @GetMapping("username/{username}")
    public User getUserGivenUsername(@PathVariable String username){

        try{
            return userService.getUserGivenUsername(username);
        }catch (Exception e){
            logger.warn("Stack Trace?",e);
            return new User();
        }
    }

    @GetMapping("email/{email}")
    public User getUserGivenEmail(@PathVariable String email){
        try{
            return userService.getUserGivenEmail(email);
        }catch (Exception e){
            logger.warn("Stack Trace?", e);
            return new User();
        }
    }
}
