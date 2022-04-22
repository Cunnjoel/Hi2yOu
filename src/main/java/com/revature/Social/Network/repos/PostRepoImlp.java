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

    /**
     * <h2>This method creates a new post/adds it to the database</h2>
     * @param post post object is passed in order to create the new post's entry
     */
    @Override
    public Integer createPost(Post post) {
        Session session = em.unwrap(Session.class);
        return (Integer) session.save(post);

    }
    /**
     * <h2>This method lists all the posts that are found in the database</h2>
     * @return the lists of posts found
     */
    @Override
    public List<Post> getAllPosts() {

        Session session = em.unwrap(Session.class);
        return session.createQuery("from Post", Post.class).getResultList();

    }
    /**
     * <h2>This method gets how many posts there are for one user</h2>
     * @param userId userId Integer is passed in order to find the matching posts
     * @return the list of posts found in the database
     */

    @Override
    public List<Post> getPostByUserId(Integer userId) {
        Session session = em.unwrap(Session.class);
        return session.createQuery("from Post", Post.class).getResultList();

    }
    /**
     * <h2>This method gets a post by postId that is found in the database</h2>
     * @param postId postId Integer is passed in order to retrieve the matching entry
     * @return the found post which matched the postId given
     */

    @Override
    public Post getPostByPostId(Integer postId) {
        Session session = em.unwrap(Session.class);
        return session.get(Post.class, postId);
    }
    /**
     * <h2>This method creates a new like by a user/adds user to the liked post</h2>
     * @param user user object is passed in order to create the new like in the post's entry
     */
    @Override
    public void createLike(Integer postId, User user) {
        Session session = em.unwrap(Session.class);

        Post post = getPostByPostId(postId);

        List<User> usersThatLike = post.getUsers();
        usersThatLike.add(user);
        post.setUsers(usersThatLike);

        session.update(post);
    }
    /**
     * <h2>This method returns all the likes for the given post</h2>
     * @param postId postId Integer is passed in order to find the post's entry and its likes
     * @return the found user(s) are saved as a User object
     */
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
        return s3Utility.bucketName + s3Utility.picturerUrl + file.getOriginalFilename();
    }
}
