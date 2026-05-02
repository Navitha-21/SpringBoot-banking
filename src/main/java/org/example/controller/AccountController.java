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
    public String deposit(@RequestBody final Map<String, Object> request, @PathVariable Long id){
        double amount = (Double)request.get("amount");
        accountService.deposit(id, amount);
        return "deposit succesfully";
    }

    @PostMapping("/withdraw/{id}")
    public String withdraw(@RequestBody final Map<String, Object> request, @PathVariable Long id){
        double amount = (Double)request.get("amount");
        accountService.withdraw(id,amount);
        return "Transfer Successfully";
    }
    @PostMapping("/transfer/{fromAcc}/{toAcc} ")
    public String transfer(@RequestBody final Map<String, Object> request,@PathVariable Long fromAcc, @PathVariable Long toAcc){
        double amount=Double.parseDouble(request.get("amount").toString());
        accountService.transfer(fromAcc, toAcc, amount);
        return "Transfer sucessfully";
    }
}
