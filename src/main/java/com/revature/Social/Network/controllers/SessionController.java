package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.Session;
import com.revature.Social.Network.models.User;
import com.revature.Social.Network.services.UserService;

import com.revature.Social.Network.utils.Hashing;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "session")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
public class SessionController {
    Logger logger = Logger.getLogger(SessionController.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<User> login(HttpSession httpSession, @RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        httpSession.setAttribute("sessionVar", user);
        return ResponseEntity.status(HttpStatus.OK).body(user);

    }

    @DeleteMapping
    public ResponseEntity<Session> logout(HttpSession httpSession){
        httpSession.setAttribute("sessionVar", null);
        Session session = new Session("Logged out and session invalidated");
        return ResponseEntity.status(HttpStatus.OK).body(session);
    }

    @GetMapping
    public ResponseEntity<User> checkSession(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("sessionVar");
        System.out.println(user);
        if(user == null){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
