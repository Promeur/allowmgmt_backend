package com.example.allowmgmt_backend.repositories;

// public class AllowanceRepository {
    
// }
// package com.example.allowmgmt_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.allowmgmt_backend.models.Allowance;
import java.util.List;
import java.util.Optional;

public interface AllowanceRepository extends JpaRepository<Allowance, Long>{
    // public interface AllowanceRepository extends JpaRepository<Allowance, Long> {
    List<Allowance> findByUserId(Long userId);
    Optional<Allowance> findByUserIdAndId(Long userId, Long id);
// }
}