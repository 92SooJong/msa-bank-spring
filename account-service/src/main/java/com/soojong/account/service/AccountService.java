package com.soojong.account.service;

import com.soojong.account.dto.CustomerDTO;
import com.soojong.account.entity.Account;
import com.soojong.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerCompositeService customerCompositeService;

    public Long createAccount(Account account) throws Exception {

        // 2) 고객정보 조회 (계좌테이블에 '고객이름' 저장을 위해)
        CustomerDTO customer = customerCompositeService.retrieveCustomer(account.getCustomerId());

        //account.(customer);

        return accountRepository.save(account).getId();
    }

}
