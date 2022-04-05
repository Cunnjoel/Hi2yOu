package com.revature.Social.Network.services;

import com.revature.Social.Network.repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PostService {

    private PostRepo postRepo;

    @Autowired
    public PostService(PostRepo postRepo) { this.postRepo = postRepo; }
}
