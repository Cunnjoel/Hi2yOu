package com.revature.repos;

import com.revature.models.User;

public interface UserRepo {

    String createUsername (String username);

    String createEmail (String email);

}
