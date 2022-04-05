package com.revature.Social.Network.repos;

import com.revature.Social.Network.models.Post;
import com.revature.Social.Network.models.User;

import java.util.List;

public interface PostRepo {
    Integer createPost(Post post);
    List<Post> getAllPosts();
    Post getPostByUserId(Integer userId);
    Integer createLike(User user);
    List<User> getAllLikes();
}
