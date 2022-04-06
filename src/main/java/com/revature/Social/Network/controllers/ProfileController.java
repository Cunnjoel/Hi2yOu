package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.Profile;
import com.revature.Social.Network.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profile")
public class ProfileController
{
    @Autowired
    ProfileService profileService;

    @PostMapping
    public void createProfile(@RequestBody Profile profile)
    {
        profileService.createProfile(profile);
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
    public void UpdateProfile(@RequestBody Profile profile)
    {
        profileService.updateProfile(profile);
    }
}
