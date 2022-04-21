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
    public User createUser(@RequestBody User user){
         user = userService.createUser(user);
        if (user != null){
            return user;
        }
        try{
            throw new Exception("Fields missing, could not create user");
        }
        catch(Exception e)
        {
            logger.warn("Stack Trace", e);
        }
        return null;
        }

        //return  userService.createUser(user);



    @PutMapping
    public User updateUser(@RequestBody User user){
         user = userService.updateUser(user);
        if (user != null)
        {
            return user;
        }
        try
        {
            throw new Exception("Please make sure new data is different that current information");
        }catch (Exception e){
            logger.warn("Stack Trace", e);
        }
        return null;

        //return userService.updateUser(user);
    }
    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);

        return "the user with the id" + userId + "was successfully deleted";
    }


    @GetMapping("username/{username}")
    public User getUserGivenUsername(@PathVariable String username){

        User user = userService.getUserGivenUsername(username);
        if(user != null){
            return user;
        }
        try{
            throw new Exception("No user with that Username");
        }catch (Exception e){
            logger.warn("Stack Trace",e);
        }
        return null;
        //return this.userService.getUserGivenUsername(username);
    }

    @GetMapping("email/{email}")
    public User getUserGivenEmail(@PathVariable String email){

        User user = userService.getUserGivenEmail(email);
        if(user != null){
            return user;
        }
        try{
            throw new Exception("That is not a valid email");
        }catch (Exception e){
            logger.warn("Stack Trace", e);
        }
        return null;
        //return this.userService.getUserGivenEmail(email);
    }
}
