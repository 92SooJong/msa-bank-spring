package com.soojong.account.service;

import com.soojong.account.dto.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerCompositeService {

    @Value("${customer.api.url}")
    private String CUSTOMER_API_URL;

    private final RestTemplate restTemplate;


    @CircuitBreaker(name = "backendA",fallbackMethod = "fallbackRetrieveCustomer")
    public String retrieveCustomer(Long customerId) throws Exception {
        String apiUrl = CUSTOMER_API_URL + "/api/v1/{customer-id}";

        Customer forObject = restTemplate.getForObject(apiUrl, Customer.class, customerId);
        //Customer forObject = new Customer();
        log.info(forObject.toString());

        return forObject.toString();
    }

    public String fallbackRetrieveCustomer(Exception ex){
//        String msg = "restTemplate를 이용하여 " + cstmId + " 고객정보 조회 서비스 호출에 문제가 있습니다.";
//        return msg;
        return "Recovered HttpServerErrorException: " + ex.getMessage();
//        log.error(msg,t);
//        throw new Exception();
    }



}
