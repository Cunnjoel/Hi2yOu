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

    @Override
    public List<User> getAll() {
        Session session =em.unwrap(Session.class);

        return session.createQuery("from User", User.class).getResultList();
    }

    @Override
    public Integer createUser(User user) {
        Session session =em.unwrap(Session.class);

        return (Integer) session.save(user);
    }

    @Override
    public void updateUser(User user) {
        Session session =em.unwrap(Session.class);

        session.update(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        Session session =em.unwrap(Session.class);

        session.delete(getOne(userId));
    }

    @Override
    public User getUserByUsername(String username) {
        Session session =em.unwrap(Session.class);

        return session.createQuery("from User where username = '" + username + "'",User.class).getSingleResult();
    }

    @Override
    public User getOne(Integer userId) {
        Session session =em.unwrap(Session.class);

        return session.get(User.class, userId);
    }
}
