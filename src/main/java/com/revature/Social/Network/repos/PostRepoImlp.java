package com.revature.Social.Network.repos;

import com.revature.Social.Network.models.Post;
import com.revature.Social.Network.models.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostRepoImlp implements PostRepo{

    @PersistenceContext
    EntityManager em;

    @Override
    public void createPost(Post post) {
        Session session = em.unwrap(Session.class);
       // return (Integer) session.save(post);
    }

    @Override
    public List<Post> getAllPosts() {

        Session session = em.unwrap(Session.class);
        return session.createQuery("from Post", Post.class).getResultList();

    }

    @Override
    public List<Post> getPostByUserId(Integer userId) {
        Session session = em.unwrap(Session.class);
        return session.createQuery("from Post", Post.class).getResultList();

    }

    @Override
    public Post getPostByPostId(Integer postId) {
        Session session = em.unwrap(Session.class);
        return session.get(Post.class, postId);
    }

    @Override
    public void createLike(Integer postId, User user) {
        Session session = em.unwrap(Session.class);

        Post post = getPostByPostId(postId);

        List<User> usersThatLike = post.getUsers();
        usersThatLike.add(user);
        post.setUsers(usersThatLike);

        session.update(post);
    }

    @Override
    public List<User> getAllLikes(Integer postId) {

        return getPostByPostId(postId).getUsers();
    }
}
