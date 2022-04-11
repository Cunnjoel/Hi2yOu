package com.revature.Social.Network.repos;

import com.revature.Social.Network.models.Post;
import com.revature.Social.Network.models.User;
import com.revature.Social.Network.utils.S3Utility;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.List;

@Repository
public class PostRepoImlp implements PostRepo{

    @Autowired
    S3Utility s3Utility;
    @PersistenceContext
    EntityManager em;

    @Override
    public Integer createPost(Post post) {
        Session session = em.unwrap(Session.class);
        if (post.getPicture() != null)
        {
            post.setPicture(s3Utility.bucketName + s3Utility.picturerUrl + post.getPicture());
        }
        return (Integer) session.save(post);
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
