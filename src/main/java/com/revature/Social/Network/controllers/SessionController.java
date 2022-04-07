package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "session")
public class SessionController {

    @PostMapping
    public ResponseEntity<User> login(HttpSession httpSession, @RequestBody User user){
        httpSession.setAttribute("sessionVar", user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping
    public ResponseEntity<String> logout(HttpSession httpSession){
        httpSession.setAttribute("sessionVar", null);
        return ResponseEntity.status(HttpStatus.OK).body("Logged out and session invalidated");
    }

    @GetMapping
    public ResponseEntity<User> checkSession(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("sessionVar");

        if(user == null){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
