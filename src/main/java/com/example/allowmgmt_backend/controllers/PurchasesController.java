package com.example.allowmgmt_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.allowmgmt_backend.models.Purchases;
import com.example.allowmgmt_backend.repositories.PurchaseRepository;

import com.example.allowmgmt_backend.models.Allowance;
import com.example.allowmgmt_backend.repositories.AllowanceRepository;

@RestController
@RequestMapping("/api/purchases")
@CrossOrigin(origins = "https://allowmgmt.vercel.app", allowCredentials = "true")
public class PurchasesController {
    
    @Autowired
    private PurchaseRepository repo;

    @Autowired
    private AllowanceRepository allowanceRepo;

    @GetMapping("/{userId}")
    public List<Purchases> getUserPurchases(@PathVariable Long userId){

        return repo.findByUserId(userId);

    }

    @GetMapping("/{userId}/{allowanceId}")
    public List<Purchases> getUserPurchasesByAllowance(
        @PathVariable Long userId,
        @PathVariable Long allowanceId
    ){
        // return repo.findByUserIdAndAllowanceId(userId, allowanceId);
        return repo.findByUserIdAndAllowanceIdOrderByIdDesc(userId, allowanceId);
    }

    @PutMapping("/{userId}/{allowanceId}/new")
    public Purchases newPurchases(
        @PathVariable Long userId,
        @PathVariable Long allowanceId,
        @RequestParam String name,
        @RequestParam Double amount
    ){
        
        Purchases newPurchase = new Purchases();
        newPurchase.setUserId(userId);
        newPurchase.setAllowanceId(allowanceId);
        newPurchase.setName(name);
        newPurchase.setAmount(amount);
        newPurchase.setPurchaseDate(java.time.LocalDateTime.now());

        Allowance allowance = allowanceRepo.findByUserIdAndId(userId, allowanceId).orElse(null);
        allowance.setAllowance(allowance.getAllowance() - amount);

        allowanceRepo.save(allowance);

        return repo.save(newPurchase);

        // return "redirect:/"

    }

}
