package com.soojong.customer.controller;

import com.soojong.customer.entity.Customer;
import com.soojong.customer.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @ApiOperation(value = "고객기본조회", httpMethod = "GET", notes = "고객기본조회")
    @GetMapping("/api/v1/{customer-id}")
    public Customer retrieveCustomer(@PathVariable(name = "customer-id") Long userId) throws Exception {
        log.info("고객기본정보 조회 시작");
        Thread.sleep(2000);
        return customerService.retrieveCustomer(userId);
    }

    @ApiOperation(value = "고객등록", httpMethod = "POST", notes = "고객등록")
    @PostMapping("/api/v1")
    public Long createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

}
