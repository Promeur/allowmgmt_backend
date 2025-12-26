package com.example.allowmgmt_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.allowmgmt_backend.models.Purchases;
import java.util.List;
// import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<Purchases, Long> {
    
    List<Purchases> findByUserId(Long userId);

    List<Purchases> findByUserIdAndAllowanceId(Long userId, Long allowanceId);

    List<Purchases> findByUserIdAndAllowanceIdOrderByIdDesc(Long userId, Long allowanceId);

}
