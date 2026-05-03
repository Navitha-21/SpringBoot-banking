package org.example.controller;

import org.example.model.Account;
import org.example.model.Transactions;
import org.example.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    AccountController(final AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account){
        return accountService.save(account);
    }

    @GetMapping 
    public List<Account> getAllAccount(){
        return accountService.findAll();
    }

    @PutMapping("/{id}")
    public Account update(@PathVariable Long id, @RequestBody Account account){
        return this.accountService.update(id, account);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        this.accountService.delete(id);
        return "Account Deleted";
    }


    @PostMapping("/deposit/{id}")
    public void deposit(@RequestBody final Map<String, Object> request, @PathVariable Long id){
        double amount = ((Number) request.get("amount")).doubleValue();
        accountService.deposit(id, amount);
    }

    @PostMapping("/withdraw/{id}")
    public void withdraw(@RequestBody final Map<String, Object> request, @PathVariable Long id){
        double amount = ((Number) request.get("amount")).doubleValue();
        accountService.withdraw(id,amount);
    }
    @PostMapping("/transfer/{fromAcc}/{toAcc}")
    public void transfer(@RequestBody final Map<String, Object> request,@PathVariable Long fromAcc, @PathVariable Long toAcc){
        double amount = ((Number) request.get("amount")).doubleValue();
        accountService.transfer(fromAcc, toAcc, amount);
    }



}
