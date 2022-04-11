package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.Profile;
import com.revature.Social.Network.models.User;
import com.revature.Social.Network.services.ProfileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ProfileControllerTest
{

    private ProfileController profileController;

    private ProfileService profileService = Mockito.mock(ProfileService.class);

    public ProfileControllerTest()
    {
        this.profileController = new ProfileController(profileService);
    }

    @Test
    void createProfile()
    {
        User newUser = new User();
        Profile expectedProfile = profileController.createProfile(new Profile(1,null,newUser,"Kevin",null,"Childs","7/05/1985","Houston","Texas",null));

        Profile actaulProfile = profileService.createProfile(expectedProfile);

        Assertions.assertEquals(expectedProfile,actaulProfile);

    }

    @Test
    void getProfileById()
    {
        Profile expectedProfile = profileController.getProfileById(1);

        Profile actaulProfile = profileService.getProfile(1);

        Assertions.assertEquals(expectedProfile,actaulProfile);
    }

    @Test
    void getProfileByUser()
    {
        Profile expectedProfile = profileController.getProfileByUser(1);

        Profile actaulProfile = profileService.getUserProfile(1);

        Assertions.assertEquals(expectedProfile,actaulProfile);
    }

    @Test
    void updateProfile()
    {
        User newUser = new User();
        Profile expectedProfile = profileController.UpdateProfile(new Profile(1,null,newUser,"Kevin",null,"Childs","7/05/1985","Houston","Texas",null));

        Profile actaulProfile = profileService.updateProfile(expectedProfile);

        Assertions.assertEquals(expectedProfile,actaulProfile);
    }
}