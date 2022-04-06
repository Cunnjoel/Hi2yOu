package com.revature.Social.Network.services;

import com.revature.Social.Network.models.Post;
import com.revature.Social.Network.models.Profile;
import com.revature.Social.Network.repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {

    private PostRepo postRepo;

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
}
