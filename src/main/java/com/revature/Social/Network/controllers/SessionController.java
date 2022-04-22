package com.revature.Social.Network.controllers;

import com.revature.Social.Network.models.Session;
import com.revature.Social.Network.models.User;
import com.revature.Social.Network.services.UserService;

import org.apache.log4j.Logger;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "session")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
public class SessionController {
    Logger logger = Logger.getLogger(SessionController.class);

    @Autowired
    private BasicPasswordEncryptor passwordEncoder;

    private UserService userService;
    @Autowired
    public SessionController(UserService userService )
    {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> login(HttpSession httpSession, @RequestBody User user){
        User user1 = null;
        try
        {
           user1 = this.userService.getUserGivenUsername(user.getUsername());
        }
        catch(Exception e)
        {
            logger.warn("Stack Trace?", e);
            try
            {
                user1 = this.userService.getUserGivenEmail((user.getUsername()));
            }
            catch(Exception e2)
            {
                logger.warn("Stack Trace?", e2);
                user1 = new User();
            }
        }
        if (user1.getUserId() == null || passwordEncoder.checkPassword(user.getPassword(), user1.getPassword()) == false)
        {
            httpSession.setAttribute("sessionVar",null);
            return ResponseEntity.status(HttpStatus.OK).body(new User());
        }
        httpSession.setAttribute("sessionVar", user1);
        return ResponseEntity.status(HttpStatus.OK).body(user1);

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
