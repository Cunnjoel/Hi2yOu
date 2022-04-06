package com.revature.Social.Network.services;

import com.revature.Social.Network.models.Post;
import com.revature.Social.Network.models.User;
import com.revature.Social.Network.repos.PostRepo;
import com.revature.Social.Network.repos.UserRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceTest {

    PostService postService;
    PostRepo postRepo = Mockito.mock(PostRepo.class);
    UserService userService;
    UserRepo userRepo = Mockito.mock(UserRepo.class);
    public PostServiceTest() { postService = new PostService(postRepo); userService = new UserService(userRepo); }

    @Test
    void getOne() {
        Integer postId = 2;
        User newUser= new User();
        List<User> newList = new ArrayList<>();

        Post expectedOutput = new Post(postId, "lorem ipsom","picture", newList, null,newUser);

        Mockito.when(postRepo.getPostByPostId(postId)).thenReturn(expectedOutput);

        Post actualOutput = postService.getOne(postId);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void addLike() {
        Integer postId = 1;
        User user = new User();

        postService.addLike(postId, user);

        Mockito.verify(postRepo).createLike(postId, user);
    }

    @Test
    void getAllLikes() {
        Integer postId = 1;
        List<User> expectedOutput = new ArrayList<>();
        expectedOutput.add(new User(1,"user","pass", "email"));
        expectedOutput.add(new User(2,"user3","pass", "email3"));
        Mockito.when(postRepo.getAllLikes()).thenReturn(expectedOutput);

        List<User> actualOutput = postService.getAllLikes();

        assertEquals(expectedOutput, actualOutput);
    }
}