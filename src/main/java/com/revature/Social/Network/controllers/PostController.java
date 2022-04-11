package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.Post;
import com.revature.Social.Network.models.User;
import com.revature.Social.Network.repos.PostRepo;
import com.revature.Social.Network.services.PostService;
import com.revature.Social.Network.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    Logger logger = Logger.getLogger(PostController.class);

    private PostService postService;

    private UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) { this.postService = postService; this.userService = userService; }

    @PostMapping
    public void createPost(@RequestBody Post post) {
        postService.createPost(post);
    }

    @GetMapping("/user/{userId}")
    public List<Post> getPostByUserId(@PathVariable Integer userId)
    {
        return this.postService.getPostByUserId(userId);
    }

    @GetMapping
    public List<Post> getAllPosts()
    {
        return this.postService.getAllPosts();
    }

    @GetMapping("{postId}")
    public Post getOne(@PathVariable Integer postId) {
        return this.postService.getOne(postId);
    }

    @PatchMapping("{postId}/user/{userId}")
    public void addLike(@PathVariable Integer postId, @PathVariable Integer userId) {
        postService.addLike(postId, userService.getUserById(userId));
    }

    @GetMapping("{postId}/likes")
    public List<User> getAllLikes(@PathVariable Integer postId) { return this.postService.getAllLikes(postId); }

    @PostMapping("upload")
    public String uploadProfilePic(@RequestParam("file") MultipartFile file)
    {
        return this.postService.uploadProfilePic(file);
    }
}
