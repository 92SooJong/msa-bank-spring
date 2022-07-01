package com.soojong.customer.service;

import com.soojong.customer.entity.Customer;
import com.soojong.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Long createCustomer(Customer customer){
        return customerRepository.save(customer).getId();
    }

    public Customer retrieveCustomer(Long userId) throws Exception {

        return customerRepository.findById(userId).orElseThrow(Exception::new);
    }



}
