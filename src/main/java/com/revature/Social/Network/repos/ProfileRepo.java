package com.revature.Social.Network.repos;

import com.revature.Social.Network.models.Profile;

public interface ProfileRepo
{
    Profile getProfileById(Integer profileId);
    void createProfile(Profile profile);
    void updateProfile(Profile profile);
    Profile getProfileByUserId(Integer userId);
}
