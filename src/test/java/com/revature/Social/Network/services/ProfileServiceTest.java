package com.revature.Social.Network.services;

import com.revature.Social.Network.models.Profile;
import com.revature.Social.Network.models.User;
import com.revature.Social.Network.repos.ProfileRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ProfileServiceTest
{

    private ProfileService profileService;

    private ProfileRepo profileRepo = Mockito.mock(ProfileRepo.class);

    public ProfileServiceTest()
    {
        this.profileService = new ProfileService(profileRepo);
    }
    @Test
    void createProfile()
    {
        User newUser = new User();
        Profile profileToPass = new Profile(1,null,newUser,"Kevin",null,"Childs","7/05/1985","Houston","Texas",null);
        profileService.createProfile(profileToPass);

        Mockito.verify(profileRepo,Mockito.times(1)).createProfile(profileToPass);
    }

    @Test
    void getProfile()
    {
        Integer profileId = 1;
        User newUser = new User();
        Profile expectedProfile = new Profile(1,null,newUser,"Kevin",null,"Childs","7/05/1985","Houston","Texas",null);
        Mockito.when(profileRepo.getProfileById(profileId)).thenReturn(expectedProfile);

        Profile actualProfile = profileService.getProfile(profileId);

        assertEquals(expectedProfile,actualProfile);
    }

    @Test
    void getUserProfile()
    {
        Integer userId = 1;
        User newUser = new User();
        Profile expectedProfile = new Profile(1,null,newUser,"Kevin",null,"Childs","7/05/1985","Houston","Texas",null);
        Mockito.when(profileRepo.getProfileByUserId(userId)).thenReturn(expectedProfile);

        Profile actualProfile = profileService.getUserProfile(userId);

        assertEquals(expectedProfile,actualProfile);
    }

    @Test
    void updateProfile()
    {
        User newUser = new User();
        Profile updatedProfile = new Profile(1,null,newUser,"Kevin","M","Childs","7/05/1985","Houston","Texas"," Hi my name is Kevin and I'll be your instructor.");
        profileService.updateProfile(updatedProfile);

        Mockito.verify(profileRepo,Mockito.times(1)).updateProfile(updatedProfile);
    }
}