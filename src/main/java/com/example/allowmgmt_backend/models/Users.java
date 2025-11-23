package com.example.allowmgmt_backend.models;


// import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }

    public String getUsername(){ return username; }
    public void setUsername(String username){ this.username=username; }

    public String getPassword(){ return password; }
    public void setPassword(String password){ this.password=password; }

    // @OneToMany
    // @JoinColumn(name="user_id", referencedColumnName="id")
    // private List<Allowance> allowances;

    // public List<Allowance> getAllowances() { return allowances; }
    // public void setAllowances(List<Allowance> allowances) { this.allowances = allowances; }



}
