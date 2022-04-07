package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.Post;
import com.revature.Social.Network.models.User;
import com.revature.Social.Network.repos.PostRepo;
import com.revature.Social.Network.services.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostControllerTest {

    PostController postController;

    PostService postService = Mockito.mock(PostService.class);

    public PostControllerTest() {
        postController = new PostController(postService);
    }
    @Test
    void createPost() {
        //arrange
        User user = new User(1, "fname", "lname", "email");
        Post post = new Post(1, "Message1", " ", null, null, user);

        //act
        postController.createPost(post);

        //assert
        Mockito.verify(postService, Mockito.times(1)).createPost(post);


    }

    @Test
    void getPostByUserId() {
        //arrange
        Integer userId = 1;

        List<Post> expectedOutput = new ArrayList<>();
        User user = new User(1, "fname", "lname", "email");
        expectedOutput.add(new Post(1, "Message1", " ", null, null, user));
        expectedOutput.add(new Post(2, "Message2", " ", null, null, user));
        Mockito.when(postService.getPostByUserId(userId)).thenReturn(expectedOutput);

        //act
        List<Post> actualOutput = postController.getPostByUserId(userId);

        //assert
        assertEquals(expectedOutput, actualOutput);


    }

    @Test
    void getAllPosts() {
        //  arrange

        List<Post> expectedOutput = new ArrayList<>();
        User user = new User(1, "fname", "lname", "email");
        expectedOutput.add(new Post(1, "Message1", " ", null, null, user));
        expectedOutput.add(new Post(2, "Message2", " ", null, null, user));
        Mockito.when(postService.getAllPosts()).thenReturn(expectedOutput);

        //act
        List<Post> actualOutput = postController.getAllPosts();

        //assert
        assertEquals(expectedOutput, actualOutput);


    }
}