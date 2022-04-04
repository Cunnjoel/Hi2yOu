package com.revature.Social.Network.repos;

import com.revature.Social.Network.models.Profile;

public interface ProfileRepo
{
    Profile getProfileById(Integer userId);
    Integer createProfile(Profile profile);
    Profile updateProfile(Integer profileId, Profile profile);
}
