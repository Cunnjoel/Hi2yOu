package com.revature.Social.Network.services;

import com.revature.Social.Network.models.Profile;
import com.revature.Social.Network.models.User;
import com.revature.Social.Network.repos.ProfileRepo;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
        Integer profileId = this.profileRepo.createProfile(profile);

        return this.profileRepo.getProfileById(profileId);
    }

    public Profile getProfile(Integer profileId)
    {
        return this.profileRepo.getProfileById(profileId);
    }

    public Profile getUserProfile(User user)
    {
        return this.profileRepo.getProfileByUserId(user);
    }

    public Profile updateProfile(Profile profile)
    {
        this.profileRepo.updateProfile(profile);

        return this.profileRepo.getProfileById(profile.getId());
    }

    public String uploadProfilePic(MultipartFile file)
    {
        return this.profileRepo.uploadProfilePic(file);
    }
}
