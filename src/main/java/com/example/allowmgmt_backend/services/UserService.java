package com.example.allowmgmt_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.allowmgmt_backend.models.Users;
import com.example.allowmgmt_backend.repositories.UserRepository;

// import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public Users getUserById(Long id){
        return userRepo.findById(id).orElse(null);
    }
    
}
