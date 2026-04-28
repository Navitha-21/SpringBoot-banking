package org.example.controller;

import org.example.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    AccountController(final AccountService accountService){
        this.accountService=accountService;
    }

}
