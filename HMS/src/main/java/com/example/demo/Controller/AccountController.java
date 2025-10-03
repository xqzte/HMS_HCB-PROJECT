package com.example.demo.Controller;

import com.example.demo.Entities.Account;
import com.example.demo.Service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/register")
    public Account create (@RequestBody Account account){
        return accountService.saveUser(account);
    }

    @GetMapping
    public List<Account> getAllAccounts (){
        return accountService.getUsers();
    }

    @GetMapping("/{email}")

    public Account findById (@PathVariable String email){
        return accountService.getUserByEmail(email).orElseThrow(()-> new RuntimeException("User Not Found"));
    }

    @PutMapping("/{email}")
    public Account update (@PathVariable String email, @RequestBody Account account){
        return accountService.updatAccount(email,account);
    }

    @DeleteMapping("/{email}")
    public void  delete(@PathVariable String email){
        accountService.deleteUser(email);
    }
}