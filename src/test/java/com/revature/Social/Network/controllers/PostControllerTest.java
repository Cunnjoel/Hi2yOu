package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.Post;
import com.revature.Social.Network.models.User;
import com.revature.Social.Network.services.PostService;
import com.revature.Social.Network.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostControllerTest {

    PostController postController;
    PostService postService = Mockito.mock(PostService.class);

    public PostControllerTest(){
        postController = new PostController(postService);
    }


    @Test
    void getOne() {
        Integer postId = 2;
        User newUser= new User();
        List<User> newList = new ArrayList<>();

        Post expectedOutput = new Post(postId, "lorem ipsom","picture", newList, null,newUser);

        Mockito.when(postService.getOne(postId)).thenReturn(expectedOutput);

        Post actualOutput = postController.getOne(postId);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void addLike() {
        Integer postId = 1;
        User user = new User();

        postController.addLike(postId, user);

        Mockito.verify(postService).addLike(postId, user);
    }

    @Test
    void getAllLikes() {
        Integer postId = 1;
        List<User> expectedOutput = new ArrayList<>();
        expectedOutput.add(new User(1,"user","pass", "email"));
        expectedOutput.add(new User(2,"user3","pass", "email3"));
        Mockito.when(postService.getAllLikes()).thenReturn(expectedOutput);

        List<User> actualOutput = postController.getAllLikes();

        assertEquals(expectedOutput, actualOutput);
    }

    public static class UserControllerTest {

        private UserController userController;

        private UserService userService = Mockito.mock(UserService.class);

        public UserControllerTest() {
            this.userController = new UserController(userService);
        }

       @Test
        void createUser(){

       }
    }
}