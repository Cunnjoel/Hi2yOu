package com.revature.Social.Network.repos;

import com.revature.Social.Network.models.Profile;
import com.revature.Social.Network.utils.S3Utility;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;

@Repository
public class ProfileRepoImpl implements ProfileRepo
{


    @Autowired
    S3Utility s3Utility;
    @PersistenceContext
    EntityManager em;

    /**
     *<h2>This method will get a Profie from the database</h2>
     * @param profileId the primary key associated to the profile
     * @return Profile object from the database
     */
    @Override
    public Profile getProfileById(Integer profileId)
    {
        Session session = em.unwrap(Session.class);
        return session.get(Profile.class,profileId);
    }

    /**
     * <h2>This method creates a new profile to the database</h2>
     * @param profile profile object to add to database
     */
    @Override
    public Integer createProfile(Profile profile)
    {
        Session session = em.unwrap(Session.class);
        if (profile.getPictureUrl() != null)
        {
            System.out.println(profile.getPictureUrl());
            System.out.println(s3Utility.bucketName);
            System.out.println(s3Utility.picturerUrl);
            profile.setPictureUrl(s3Utility.bucketName + s3Utility.picturerUrl + profile.getPictureUrl());
        }
        return (Integer) session.save(profile);
    }

    /**
     * <h2>This method updates the information of a profile in the database</h2?>
     * @param profile profile object with updated information
     */
    @Override
    public void updateProfile(Profile profile)
    {
        Session session = em.unwrap(Session.class);
        if (profile.getPictureUrl() != null)
        {
            profile.setPictureUrl(s3Utility.bucketName + s3Utility.picturerUrl + profile.getPictureUrl());
        }
        session.update(profile);
    }

    /**
     * <h2>This method gets a profile from the database given a users id</h2>
     * @param userId number associated with the user who's profile we want
     * @return profile object from the database
     */
    @Override
    public Profile getProfileByUserId(Integer userId)
    {
        Session session = em.unwrap(Session.class);
        return session.createQuery("from Profile where user = '" + userId + "'",Profile.class).getSingleResult();
    }

    /**
     * <h2>This method gets an image file and uploads it to an S3 bucket</h2>
     * @param file the file to upload to the bucket
     * @return string to tell the user if upload was successful or not
     */
    @Override
    public String uploadProfilePic(MultipartFile file)
    {
        Session session = em.unwrap(Session.class);
        try
        {
            s3Utility.uploadFile(file);
        }
        catch (IOException e)
        {
            System.out.println(e.getStackTrace());
            return "Filed not uploaded!";
        }
        return "Filed uploaded Successfully";
    }
}
