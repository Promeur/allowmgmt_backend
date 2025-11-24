package com.example.allowmgmt_backend.controllers;

// import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.allowmgmt_backend.models.Users;
import com.example.allowmgmt_backend.services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private UserService service;

    // @GetMapping
    // public List<Users> getUsers(){
    //     return service.getAllUsers();
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        // return service.getUserById(id);
        Optional<Users> user = Optional.ofNullable(service.getUserById(id));
        System.out.println("User found: " + user); // logs to see what's returned
        return user.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

}
