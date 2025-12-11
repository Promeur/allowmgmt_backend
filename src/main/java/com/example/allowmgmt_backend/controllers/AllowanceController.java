// package com.example.allowmgmt_backend.controllers;

// public class AllowanceController {
    
// }

package com.example.allowmgmt_backend.controllers;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.allowmgmt_backend.models.Allowance;
import com.example.allowmgmt_backend.repositories.AllowanceRepository;
// import com.example.allowmgmt_backend.services.AllowanceService;

@RestController
@RequestMapping("/api/allowance")
@CrossOrigin(origins = "*")
public class AllowanceController {
    
    // @Autowired
    // private AllowanceService service;

    // @GetMapping
    // public List<Users> getUsers(){
    //     return service.getAllUsers();
    // }

    // @GetMapping("/{user_id}")
    // public Allowance getAllowanceByUserId(@PathVariable Long user_id) {
    //     return service.getAllowanceById(user_id);
    // }

     @Autowired
    private AllowanceRepository repo;

    // @GetMapping("/{userId}")
    // public List<Allowance> getUserAllowance(@PathVariable Long userId) {
    //     return repo.findByUserId(userId);
    // }

    @GetMapping("/{userId}/{id}")
    public Allowance getUserAllowanceByName(@PathVariable Long userId,
                                            @PathVariable Long id) {
        return repo.findByUserIdAndId(userId, id).orElse(null);
    }

    @PutMapping("/{userId}/{id}/add")
    public Allowance addAllowance(
        @PathVariable Long userId,
        @PathVariable Long id,
        @RequestParam Double amountToAdd
    )
    {

        Allowance allowance = repo.findByUserIdAndId(userId, id).orElse(null);
        allowance.setAllowance(allowance.getAllowance() + amountToAdd);
        
        return repo.save(allowance);

    }

}
