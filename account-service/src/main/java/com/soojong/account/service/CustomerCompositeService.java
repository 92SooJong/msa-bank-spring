package com.soojong.account.service;

import com.soojong.account.dto.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerCompositeService {

    @Value("${customer.api.url}")
    private String CUSTOMER_API_URL;
    private final RestTemplate restTemplate;


    @CircuitBreaker(name = "backendA",fallbackMethod = "fallbackRetrieveCustomer")
    public Optional<Customer> retrieveCustomer(Long customerId){
        String apiUrl = CUSTOMER_API_URL + "/api/v1/{customer-id}";

        Customer forObject = restTemplate.getForObject(apiUrl, Customer.class, customerId);

        return Optional.ofNullable(forObject);
    }

    public Optional<Customer> fallbackRetrieveCustomer(Long customerId,Exception ex){

        log.info(ex.getClass()+" => "+ex.getMessage());
        log.info("{} ID를 가진 고객 정보를 불러오지 못했습니다",customerId);
        return Optional.empty();

    }

}
