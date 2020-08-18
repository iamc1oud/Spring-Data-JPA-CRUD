package com.softai.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> allUsers() {

        return userService.findAll();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/users/count")
    public Long count() {

        return userService.count();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {

        Long userId = Long.parseLong(id);
        userService.deleteById(userId);
    }
}
