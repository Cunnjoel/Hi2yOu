package com.revature.Social.Network.services;

import com.revature.Social.Network.models.Post;

import com.revature.Social.Network.models.User;

import com.revature.Social.Network.repos.PostRepo;
import com.revature.Social.Network.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {

    PostRepo postRepo;

    @Autowired
    public PostService(PostRepo postRepo) { this.postRepo = postRepo; }


    public Post createPost(Post post)
    {
        Integer postId = this.postRepo.createPost(post);

        Post postFromDb = this.postRepo.getPostByPostId(postId);
        return postFromDb;
    }
    public List<Post> getAllPosts(){ return this.postRepo.getAllPosts();
    }
    public List<Post> getPostByUserId(Integer userId){ return this.postRepo.getPostByUserId(userId);
    }

    public Post getOne(Integer postId) { return this.postRepo.getPostByPostId(postId); }

    public void addLike(Integer postId, User user) {
        this.postRepo.createLike(postId, user);
    }

    public List<User> getAllLikes(){ return this.postRepo.getAllLikes(); }

}