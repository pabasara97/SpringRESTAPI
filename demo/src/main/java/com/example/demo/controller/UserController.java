/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.serrvice.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/User/addUser")
    public User addUser(@RequestBody User product) {
        return service.saveUser(product);
    }

    @PostMapping("/User/addUsers")
    public List<User> addUsers(@RequestBody List<User> products) {
        return service.saveUsers(products);
    }

    @GetMapping("/User/users")
    public List<User> findAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/User/userById/{id}")
    public User findUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @GetMapping("/User/user/{name}")
    public User findUserByName(@PathVariable String name) {
        return service.getUserByName(name);
    }

    @PutMapping("/User/update")
    public User updateUser(@RequestBody User product) {
        return service.updateUser(product);
    }

    @DeleteMapping("/User/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}
