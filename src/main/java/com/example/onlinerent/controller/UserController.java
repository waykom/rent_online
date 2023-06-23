package com.example.onlinerent.controller;


import com.example.onlinerent.model.RespBean;
import com.example.onlinerent.model.RespPageBean;
import com.example.onlinerent.model.User;
import com.example.onlinerent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public RespPageBean getUserPages(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            String name){
        return userService.getUserByPage(page,size,name);
    }
    @PostMapping
    public RespBean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public RespBean deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }

    @PutMapping
    public RespBean updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
