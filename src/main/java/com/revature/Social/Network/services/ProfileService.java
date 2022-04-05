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

    public Profile createProfile(Profile profile)
    {
        Integer postId = this.profileRepo.createProfile(profile);

        Profile profileFromDb = this.profileRepo.getProfileById(postId);
        return profileFromDb;
    }

    public Profile getProfile(Integer profileId)
    {
        return this.profileRepo.getProfileById(profileId);
    }

    public Profile getUserProfile(Integer userId)
    {
        return this.profileRepo.getProfileByUserId(userId);
    }

    public Profile updateProfile(Profile profile)
    {
        return this.profileRepo.updateProfile(profile);
    }
}
