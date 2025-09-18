package com.example.demo.Entities;


import jakarta.persistence.*;

@Entity
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String department;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;


    public Nurse(){}

    public Nurse(Long id, String department, Account account, String department1) {
        this.id = id;
        this.department = department;
        this.account = account;
        this.department = department1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
