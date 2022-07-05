package com.soojong.account.service;

import com.soojong.account.dto.Customer;
import com.soojong.account.entity.Account;
import com.soojong.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerCompositeService customerCompositeService;

    public Long createAccount(Account account) throws Exception {


        Optional<Customer> optionalCustomer = customerCompositeService.retrieveCustomer(account.getCustomerId());

        Customer customer = optionalCustomer.orElseThrow(() -> new Exception("고객정보가 없습니다!"));

        account.setCustomerName(customer.getCustomerName());

        return accountRepository.save(account).getId();
    }

}
