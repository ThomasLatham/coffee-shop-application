package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService us;

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public User getUserByLogin(@RequestBody User u){ return us.getUserByLogin(u); }

    @PostMapping(value = "/user", consumes = "application/json", produces = "application/json")
    public User addActor(@RequestBody User u) {
        return us.addUser(u);
    }

}
