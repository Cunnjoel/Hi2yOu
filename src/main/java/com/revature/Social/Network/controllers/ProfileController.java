package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.Picture;
import com.revature.Social.Network.models.Profile;
import com.revature.Social.Network.services.ProfileService;
import com.revature.Social.Network.services.UserService;
import org.apache.log4j.Logger;
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
    public Profile updateProfile(@RequestBody Profile profile)
    {
        return profileService.updateProfile(profile);
    }

    @PostMapping("upload")
    public Picture uploadProfilePic(@RequestParam(value = "file",required = false)MultipartFile file)
    {
        Picture picture;
        if (file != null)
        {
            System.out.println(file.getOriginalFilename());
            picture = new Picture(this.profileService.uploadProfilePic(file));
        }
        else
        {
            picture = null;
        }
        return picture;
    }
}
