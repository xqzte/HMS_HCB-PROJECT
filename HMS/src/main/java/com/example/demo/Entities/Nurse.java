package com.example.demo.Entities;


import jakarta.persistence.*;

@Entity
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String department;
    private int yearsOfExperience;
    private String gender;
    private String password;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;



    public Nurse(){}

    public Nurse(Long id, String department, Account account, String department1, String name, int yearsOfExperience, String email, String gender, String password) {
        this.id = id;
        this.department = department;
        this.account = account;
        this.department = department1;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
