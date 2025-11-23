package com.example.allowmgmt_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.allowmgmt_backend.models.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
    
}
