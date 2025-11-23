package com.example.allowmgmt_backend.models;

// public class Allowance {
    
// }
// package com.example.allowmgmt_backend.models;

import jakarta.persistence.*;

@Entity
@Table(name="allowance")
public class Allowance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="name")
    private String name;

    @Column(name="allowance")
    private Double allowance;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }

    public Long getUserId(){ return userId; }
    public void setUserId(Long userId){ this.userId=userId; }

    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }

    public Double getAllowance() { return allowance; }
    public void setAllowance(Double allowance) { this.allowance=allowance;}

}
