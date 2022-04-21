package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.Picture;
import com.revature.Social.Network.models.Profile;
import com.revature.Social.Network.services.ProfileService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("profile")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
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
        try
        {
            return profileService.createProfile(profile);
        }
        catch(Exception e)
        {
            logger.warn("Stack Trace?",e);
            return new Profile();
        }
    }

    @GetMapping("profile/{profileId}")
    public Profile getProfileById(@PathVariable Integer profileId)
    {
        try
        {
            return profileService.getProfile(profileId);
        }
        catch(Exception e)
        {
            logger.warn("Stack Trace?",e);
            return new Profile();
        }
    }

    @GetMapping("userProfile/{userId}")
    public Profile getProfileByUser(@PathVariable Integer userId)
    {
        try
        {
            return profileService.getUserProfile(userId);
        }
        catch(Exception e)
        {
            logger.warn("Stack Trace?",e);
        }
        return null;
    }

    @PatchMapping
    public Profile updateProfile(@RequestBody Profile profile)
    {
        try
        {
            return profileService.updateProfile(profile);
        }
        catch(Exception e)
        {
            logger.warn("Stack Trace?",e);
        }
        return null;
    }

    @PostMapping("upload")
    public Picture uploadProfilePic(@RequestParam(value = "file",required = false)MultipartFile file)
    {
        Picture picture;
        if (file != null)
        {
            picture = new Picture(this.profileService.uploadProfilePic(file));
        }
        else
        {
            picture = null;
        }
        return picture;
    }
}
