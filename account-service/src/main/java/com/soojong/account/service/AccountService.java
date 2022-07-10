package com.soojong.account.service;

import com.soojong.account.dto.Customer;
import com.soojong.account.entity.Account;
import com.soojong.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final CustomerCompositeService customerCompositeService;

    public Long createAccount(Account account){


        for(int i=0; i<20; i++){
            log.info("{} 번째 요청",i+1);
            Optional<Customer> optionalCustomer = customerCompositeService.retrieveCustomer(account.getCustomerId());
        }

        //Customer customer = optionalCustomer.orElseThrow(() -> new Exception("고객정보가 없습니다!"));
        //account.setCustomerName(customer.getCustomerName());

        return null;//accountRepository.save(account).getId();
    }

}
