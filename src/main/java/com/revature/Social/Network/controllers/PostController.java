package com.revature.Social.Network.controllers;
import com.revature.Social.Network.models.Post;


import com.revature.Social.Network.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")

public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public void createProfile(@RequestBody Post post)
    {
        postService.createPost(post);
    }

    @GetMapping("userPost/{userId}")
    public List<Post> getPostByUserId(@PathVariable Integer userId)
    {
        return this.postService.getPostByUserId(userId);
    }

    @GetMapping("post")
    public List<Post> getAllPosts(@RequestBody Post post)
    {
        return this.postService.getAllPosts();
    }




}
