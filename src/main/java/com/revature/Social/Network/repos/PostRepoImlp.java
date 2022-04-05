package com.revature.Social.Network.repos;

import com.revature.Social.Network.models.Post;
import com.revature.Social.Network.models.User;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PostRepoImlp implements PostRepo{
    @PersistenceContext
    EntityManager em;

    @Override
    public Integer createPost(Post post) {
        Session session = em.unwrap(Session.class);
        return (Integer) session.save(post);
    }

    @Override
    public List<Post> getAllPosts() {

    Session session = em.unwrap(Session.class);
        return session.createQuery("from Post", Post.class).getResultList();

    }

    @Override
    public Post getPostByUserId(Integer userId) {
        return null;
    }

    @Override
    public Integer createLike(User user) {
        return null;
    }

    @Override
    public List<User> getAllLikes() {
        return null;
    }
}
