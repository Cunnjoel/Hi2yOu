package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.Profile;
import com.revature.Social.Network.services.ProfileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profile")
public class ProfileController

{
    Logger logger = Logger.getLogger(ProfileController.class);

    ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService)
    {
        this.profileService = profileService;
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile)
    {
        return profileService.createProfile(profile);
    }

    @GetMapping("profile/{profileId}")
    public Profile getProfileById(@PathVariable Integer profileId)
    {
        return profileService.getProfile(profileId);
    }

    @GetMapping("userProfile/{userId}")
    public Profile getProfileByUser(@PathVariable Integer userId)
    {
        return profileService.getUserProfile(userId);
    }

    @PatchMapping
    public Profile UpdateProfile(@RequestBody Profile profile)
    {
        return profileService.updateProfile(profile);
    }
}
