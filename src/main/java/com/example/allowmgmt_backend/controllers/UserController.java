package com.example.allowmgmt_backend.controllers;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Users getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

}
