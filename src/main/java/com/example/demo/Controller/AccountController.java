package com.example.demo.Controller;

import com.example.demo.Entities.Account;
import com.example.demo.Service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping
    public Account create (@RequestBody Account account){
        return accountService.saveUser(account);
    }

    @GetMapping
    public List<Account> getAllAccounts (){
       return accountService.getUsers();
    }

    public Account findById (@PathVariable Long id){
        return accountService.getUserById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
    }

    public Account update (@PathVariable Long id, @RequestBody Account account){
        return accountService.updateAccount(id,account);
    }

    public void  delete(@PathVariable Long id){
        accountService.deleteAccount(id);
    }
}
