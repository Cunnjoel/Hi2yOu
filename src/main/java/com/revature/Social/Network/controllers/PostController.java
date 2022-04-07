package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.Post;
import com.revature.Social.Network.models.User;
import com.revature.Social.Network.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("{postId}")
    public Post getOne(@PathVariable Integer postId) { return this.postService.getOne(postId); }

    @PatchMapping("{postId}/user/{user}")
    public Post addLike(@PathVariable Integer postId, @PathVariable User user) { postService.addLike(postId, user);
        return null;
    }

    @GetMapping("likes")
    public List<User> getAllLikes() { return this.postService.getAllLikes(); }
}
