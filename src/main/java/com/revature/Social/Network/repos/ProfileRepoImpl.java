package com.revature.Social.Network.repos;

import com.revature.Social.Network.models.Profile;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProfileRepoImpl implements ProfileRepo
{

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
}
