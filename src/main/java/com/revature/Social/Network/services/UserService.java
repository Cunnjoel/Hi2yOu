package com.revature.Social.Network.services;

import com.revature.Social.Network.models.User;
import com.revature.Social.Network.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAll(){
        return userRepo.getAll();
    }
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User createUser (User user){
        Integer userId = userRepo.createUser(user);
        User userFromDb = userRepo.getOne(userId);
        return userFromDb;
    }
    public User updateUser (User user){
        userRepo.updateUser(user);

        return userRepo.getOne(user.getUserId());
    }
    public void deleteUser(Integer userId){


        userRepo.deleteUser(userId);
    }
    public User getUserGivenUsername(String username){
        return userRepo.getUserByUsername(username);
    }

    public User getUserById(Integer userId)
    {
        return userRepo.getOne(userId);
    }
}
