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
        void getPostByUserId ()
        {

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

    @Test
    void getOne() {
        Integer postId = 2;
        User newUser= new User();
        List<User> newList = new ArrayList<>();

        Post expectedOutput = new Post(2, "lorem ipsom","picture", newList, null,newUser);

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
        Mockito.when(postRepo.getAllLikes(1)).thenReturn(expectedOutput);

        List<User> actualOutput = postService.getAllLikes(1);

        assertEquals(expectedOutput, actualOutput);
    }
}

