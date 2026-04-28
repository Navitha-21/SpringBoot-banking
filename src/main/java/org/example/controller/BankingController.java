package org.example.controller;

import org.example.model.Account;
import org.example.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/bank")
public class BankingController {

    private final AccountService accountService;

    BankingController(final AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping("/create")
    public void createAccount(@RequestBody Account account){
        accountService.save(account);
    }

    @PostMapping("deposit/{id}")
    public void deposit(@RequestBody final Map<String, Object> request, @Pathvariable Long id){
        Account ac = accountService.getById(id);
        double amount = (Double)request.get("amount");
        accountService.deposit(ac.getId(), amount);
    }
    @PostMapping("withdrawl/{id}")
    public void withdraw(@RequestBody final Map<String, Object> request, @Pathvariable Long id){
        Account acc=accountService.getById(id);
        double amount=(Double)request.get("amount");
        accountService.withdraw(acc.getId(),amount);
    }
    
    @PostMapping("/transfer")
    public void transfer(@RequestBody final Map<String, Object> request, Long fromAcc, Long toAcc){
        Account ac1=accountService.getById(fromAcc);
        Account ac2=accountService.getById(toAcc);
        double amount=(Double)request.get("amount");
        accountService.transfer(ac1.getId(), ac2.getId(), amount);
    }
}
