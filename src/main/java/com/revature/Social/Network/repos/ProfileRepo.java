package com.revature.Social.Network.repos;

import com.revature.Social.Network.models.Profile;
import com.revature.Social.Network.models.User;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileRepo
{
    Profile getProfileById(Integer profileId);
    Integer createProfile(Profile profile);
    void updateProfile(Profile profile);
    Profile getProfileByUserId(User userId);
    String uploadProfilePic(MultipartFile file);
}
