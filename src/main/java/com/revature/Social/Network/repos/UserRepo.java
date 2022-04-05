package com.revature.Social.Network.repos;

import com.revature.Social.Network.models.User;

import java.util.List;

public interface UserRepo {

    List<User> getAll();

    Integer createUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    User getUserByUsername(String username);



}
