package com.example.allowmgmt_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="purchases")
public class Purchases {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="allowance_id")
    private Long allowanceId;

    @Column(name="name")
    private String name;

    @Column(name="amount")
    private Double amount;

    @Column(name="purchase_date")
    private LocalDateTime purchaseDate;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }

    public Long getUserId(){ return userId; }
    public void setUserId(Long userId){ this.userId=userId; }

    public Long getAllowanceId() { return allowanceId; }
    public void setAllowanceId(Long allowanceId){ this.allowanceId=allowanceId; }

    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }

    public Double getAmount(){ return amount; }
    public void setAmount(Double amount){ this.amount=amount; }

    public LocalDateTime getPurchaseDate(){ return purchaseDate; }
    public void setPurchaseDate(LocalDateTime purchaseDate){ this.purchaseDate=purchaseDate; }

    // @Column(name="date")
    // private 

}
