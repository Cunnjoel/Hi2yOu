package com.revature.Social.Network.services;

import com.revature.Social.Network.models.Post;

import com.revature.Social.Network.models.User;

import com.revature.Social.Network.repos.PostRepo;
import com.revature.Social.Network.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {

    PostRepo postRepo;

    @Autowired
    public PostService(PostRepo postRepo) { this.postRepo = postRepo; }


    public void createPost(Post post)
    {
         this.postRepo.createPost(post);

    }
    public List<Post> getAllPosts(){ return this.postRepo.getAllPosts();
    }
    public List<Post> getPostByUserId(Integer userId){ return this.postRepo.getPostByUserId(userId);
    }

    public Post getOne(Integer postId) { return this.postRepo.getPostByPostId(postId); }

    public void addLike(Integer postId, User user) {
        this.postRepo.createLike(postId, user);
    }

    public List<User> getAllLikes(Integer postId){ return this.postRepo.getAllLikes(postId); }

    public String uploadPostPic(MultipartFile file)
    {
        return this.postRepo.uploadProfilePic(file);
    }
}
