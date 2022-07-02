package com.soojong.account.controller;

import com.soojong.account.entity.Account;
import com.soojong.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    public Long createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }


}
