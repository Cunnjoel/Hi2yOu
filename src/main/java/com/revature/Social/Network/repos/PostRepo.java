package com.revature.Social.Network.repos;

import com.revature.Social.Network.models.Post;
import com.revature.Social.Network.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostRepo {
    void createPost(Post post);
  
    List<Post> getAllPosts();

    List<Post> getPostByUserId(Integer userId);
  
    void createLike(Integer postId, User user);

    List<User> getAllLikes(Integer postId);
  
    Post getPostByPostId(Integer postId);

    String uploadProfilePic(MultipartFile file);
}
