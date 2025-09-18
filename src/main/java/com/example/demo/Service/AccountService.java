package com.example.demo.Service;

import com.example.demo.Entities.Account;
import com.example.demo.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class AccountService {

    private final UserRepository userRepository;

    public AccountService(UserRepository userRepository) {this.userRepository = userRepository;}

    public Account saveUser (Account account){return userRepository.save(account);}


    public List<Account> getUsers() {
        return userRepository.findAll();

    }


    public Optional<Account> getUserById(Long id){
        return  userRepository.findById(id);
    }


    public Account updateAccount(Long id, Account account){
        return userRepository.findById(id)
                .map(existing ->{
                    existing.setName(account.getName());
                    return userRepository.save(existing);
                }).orElseThrow(()-> new RuntimeException("User Not Found"));
    }


    public void deleteAccount(Long id){
        userRepository.delete(id);
    }



}
