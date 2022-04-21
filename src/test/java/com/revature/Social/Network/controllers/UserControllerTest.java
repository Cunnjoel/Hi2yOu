package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.Post;
import com.revature.Social.Network.models.User;
import com.revature.Social.Network.services.PostService;
import com.revature.Social.Network.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserControllerTest {

    UserController userController;
    UserService userService = Mockito.mock(UserService.class);

    public UserControllerTest() {
        userController = new UserController(userService);
    }

    @Test
    void createUser() {
        User newUser = new User(1, "user1", "pass123", "user1@gmail.com");

        userService.createUser(newUser);

        Mockito.verify(userService, Mockito.times(1)).createUser(newUser);
    }
    @Test
    void updateUser(){
        User updateUser = new User(1, "user1", "pass123", "user123");

        userService.updateUser(updateUser);

        Mockito.verify(userService,Mockito.times(1)).updateUser(updateUser);
    }
    @Test
    void getAllUsers(){
        List<User> expectedOutput= new ArrayList<>();
        expectedOutput.add(new User());
        Mockito.when(userService.getAll()).thenReturn(expectedOutput);

        List<User> actualOutput = userService.getAll();

        assertEquals(expectedOutput, actualOutput);
    }
    @Test
    void deleteUser(){
        Integer userId = 1;

        userService.deleteUser(userId);

        Mockito.verify(userService, Mockito.times(1)).deleteUser(userId);
    }
    @Test
    void getByUsername(){

        String expectedUsername = "user123";
        String expectedPassword = "pass123";
        String expectedEmail = "user123@gmail.com";
        User expectedOutput = new User(1, expectedUsername,expectedPassword,expectedEmail );
        Mockito.when(userService.getUserGivenUsername(expectedUsername)).thenReturn(expectedOutput);

        User actualOutput = userService.getUserGivenUsername(expectedUsername);

        assertEquals(expectedOutput, actualOutput);
    }
    @Test
    void getUserGivenEmail(){

        String expectedUsername = "user123";
        String expectedPassword = "pass123";
        String expectedEmail = "user1@gmail.com";
        User expectedOutput = new User(1, expectedUsername, expectedPassword,expectedEmail);
        Mockito.when(userService.getUserGivenEmail(expectedEmail)).thenReturn(expectedOutput);

        User actualOutput = userService.getUserGivenEmail(expectedEmail);

        assertEquals(expectedOutput, actualOutput);
    }
}