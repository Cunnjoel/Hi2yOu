package com.revature.Social.Network.repos;

import com.revature.Social.Network.models.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo{

    @PersistenceContext
    EntityManager em;

    /**
     * <h2>This method gets all the users in the database</h2>
     * @return users from database
     */
    @Override
    public List<User> getAll() {
        Session session =em.unwrap(Session.class);

        return session.createQuery("from User", User.class).getResultList();
    }

    /**
     * <h2>This method creates a new user/adds a user to the database</h2>
     * @param user user object is passed in order to create the new user entry
     * @return the new user is saved as an integer for it's userId/primary key in database
     */
    @Override
    public Integer createUser(User user) {
        Session session =em.unwrap(Session.class);

        return (Integer) session.save(user);
    }

    /**
     * <h2>This method updates an existing user account (can alter email, username,and password,</h2>
     * @param user existing user object is passed in order to update that specific user entry in the database
     */
    @Override
    public void updateUser(User user) {
        Session session =em.unwrap(Session.class);

        session.update(user);
    }

    /**
     * <h2>This method deletes an existing user account from the database</h2>
     * @param userId the primary key userId is passed to identify which account is requesting deletion
     */
    @Override
    public void deleteUser(Integer userId) {
        Session session =em.unwrap(Session.class);

        session.delete(getOne(userId));
    }

    /**
     * <h2>This method finds a specific user when given its username</h2>
     * @param username the username object is used to identify which account is being requested
     * @return returns the specified user object from database given a username
     */
    @Override
    public User getUserByUsername(String username) {
        Session session =em.unwrap(Session.class);

        return session.createQuery("from User where username = '" + username + "'",User.class).getSingleResult();
    }

    /**
     * <h2>This method gets one existing User from the database</h2>
     * @param userId The primary key userId is passed in order to find the specific user
     * @return returns the specific user object from the database after a userId is passed
     */
    @Override
    public User getOne(Integer userId) {
        Session session =em.unwrap(Session.class);

        return session.get(User.class, userId);
    }
}
