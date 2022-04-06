package com.revature.Social.Network;

import com.revature.Social.Network.models.User;
import com.revature.Social.Network.repos.UserRepo;
import com.revature.Social.Network.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    private UserService userService;

    private UserRepo userRepo = Mockito.mock(UserRepo.class);

    public UserServiceTest(){
        this.userService = new UserService(userRepo);
    }

    @Test
    void createUser(){
        User newUser = new User(1, "user1", "pass123", "user1@gmail.com");

        userService.createUser(newUser);

        Mockito.verify(userRepo, Mockito.times(1)).createUser(newUser);
    }
    @Test
    void updateUser(){
        User updateUser = new User(1, "user1", "pass123", "user123");

        userService.updateUser(updateUser);

        Mockito.verify(userRepo,Mockito.times(1)).updateUser(updateUser);
    }
    @Test
    void getAllUsers(){
        List<User> expectedOutput= new ArrayList<>();
        expectedOutput.add(new User());
        Mockito.when(userRepo.getAll()).thenReturn(expectedOutput);

        List<User> actualOutput = userRepo.getAll();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void deleteUser(){
        Integer userId = 1;

        userService.deleteUser(userId);

        Mockito.verify(userRepo, Mockito.times(1)).deleteUser(userId);
    }

    @Test
    void getByUsername(){

        String expectedUsername = "user123";
        String expectedPassword = "pass123";
        String expectedEmail = "user123@gmail.com";
        User expectedOutput = new User(1, expectedUsername,expectedPassword,expectedEmail );
        Mockito.when(userRepo.getUserByUsername(expectedUsername)).thenReturn(expectedOutput);

        User actualOutput = userService.getUserGivenUsername(expectedUsername);

        assertEquals(expectedOutput, actualOutput);
    }
}
