package com.revature.Social.Network.services;

import com.revature.Social.Network.models.Profile;
import com.revature.Social.Network.repos.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProfileService
{
    ProfileRepo profileRepo;

    @Autowired
    public ProfileService(ProfileRepo profileRepo)
    {
        this.profileRepo = profileRepo;
    }

    public void createProfile(Profile profile)
    {
        this.profileRepo.createProfile(profile);
    }

    public Profile getProfile(Integer profileId)
    {
        return this.profileRepo.getProfileById(profileId);
    }

    public Profile getUserProfile(Integer userId)
    {
        return this.profileRepo.getProfileByUserId(userId);
    }

    public void updateProfile(Profile profile)
    {
        this.profileRepo.updateProfile(profile);
    }
}
