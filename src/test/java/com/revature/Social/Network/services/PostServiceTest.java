package com.revature.Social.Network.services;

import com.revature.Social.Network.models.Post;
import com.revature.Social.Network.models.User;
import com.revature.Social.Network.repos.PostRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceTest {

    PostService postService;
    PostRepo postRepo = Mockito.mock(PostRepo.class);

    public PostServiceTest() {
        postService = new PostService(postRepo);
    }

        @Test
        void createPost () {
            //arrange
            User user = new User(1, "fname", "lname", "email");
            Post post = new Post(1, "Message1", " ", null, null, user);

            //act
            postService.createPost(post);

            //assert
            Mockito.verify(postRepo, Mockito.times(1)).createPost(post);

        }

        @Test
        void getAllPosts () {

            //  arrange

            List<Post> expectedOutput = new ArrayList<>();
            User user = new User(1, "fname", "lname", "email");
            expectedOutput.add(new Post(1, "Message1", " ", null, null, user));
            expectedOutput.add(new Post(2, "Message2", " ", null, null, user));
            Mockito.when(postRepo.getAllPosts()).thenReturn(expectedOutput);

            //act
            List<Post> actualOutput = postService.getAllPosts();

            //assert
            assertEquals(expectedOutput, actualOutput);

        }

        @Test
        void getPostByUserId () {

            //arrange
            Integer userId = 1;

            List<Post> expectedOutput = new ArrayList<>();
            User user = new User(1, "fname", "lname", "email");
            expectedOutput.add(new Post(1, "Message1", " ", null, null, user));
            expectedOutput.add(new Post(2, "Message2", " ", null, null, user));
            Mockito.when(postRepo.getPostByUserId(userId)).thenReturn(expectedOutput);

            //act
            List<Post> actualOutput = postService.getPostByUserId(userId);

            //assert
            assertEquals(expectedOutput, actualOutput);

        }
    }
