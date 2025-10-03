package com.example.demo.Service;

import com.example.demo.Entities.Account;
import com.example.demo.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public Account saveUser(Account account) {
        return accountRepository.save(account);
    }


    public List<Account> getUsers() {
        return accountRepository.findAll();

    }


    public Optional<Account> getUserByEmail(String email) {

        return accountRepository.findByEmail(email);
    }


    public Account updatAccount(String email, Account account) {
        return accountRepository.findByEmail(email)
                .map(existing -> {
                    existing.setName(account.getName());
                    return accountRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("user not found with email: " + email));
    }


    public void deleteUser(String email) {
        AccountRepository.deleteByEmail(email);

    }
}
