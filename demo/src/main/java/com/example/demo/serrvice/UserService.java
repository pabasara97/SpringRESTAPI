/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.serrvice;



import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserService {
     @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(long id) {
        return repository.findById(id).orElse(null);
    }

    public User getUserByName(String name) {
        return repository.findByName(name);
    }

    public String deleteUser(long id) {
        repository.deleteById(id);
        return "User removed !! " + id;
    }

    public User updateUser(User User) {
        User existingUser = repository.findById(User.getId()).orElse(null);
        existingUser.setName(User.getName());
        existingUser.setEmail(User.getEmail());
        existingUser.setPassword(User.getPassword());
        return repository.save(existingUser);
    }

}
