package com.example.ITsupport.controller;

import com.example.ITsupport.Dto.SignupRequest;
import com.example.ITsupport.entity.User;
import com.example.ITsupport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("admin/newUser")
    public String newUser(@RequestBody SignupRequest user) {
        return userService.newUser(user);
    }
    @PutMapping("admin/updateUser/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody SignupRequest user) {
        userService.updateUser(id, user);
        return "update user success";
    }

    @DeleteMapping("admin/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return userService.removeUser(id);
    }

    @GetMapping("admin/AllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
