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

    @Override
    public Profile getProfileById(Integer profileId)
    {
        Session session = em.unwrap(Session.class);
        return session.get(Profile.class,profileId);
    }

    @Override
    public Integer createProfile(Profile profile)
    {
        Session session = em.unwrap(Session.class);
        return (Integer)session.save(profile);
    }

    @Override
    public Profile updateProfile(Profile profile)
    {
        Session session = em.unwrap(Session.class);
        session.update(profile);
        return profile;
    }

    @Override
    public Profile getProfileByUserId(Integer userId)
    {
        Session session = em.unwrap(Session.class);
        return session.createQuery("from profile where user = :userId",Profile.class).getSingleResult();
    }
}
