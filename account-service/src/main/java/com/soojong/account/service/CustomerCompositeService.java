package com.soojong.account.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.soojong.account.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerCompositeService {


    @Value("${customer.api.url}")
    private String CUSTOMER_API_URL;

    private final RestTemplate restTemplate;

    @HystrixCommand(commandKey="retrieveCustomer", fallbackMethod="fallbackRetrieveCustomer")
    public CustomerDTO retrieveCustomer(Long cstmId) throws Exception {
        String apiUrl = "/api/v1/{customer-id}";

        return this.restTemplate.getForObject(CUSTOMER_API_URL + apiUrl,
                CustomerDTO.class, cstmId);
    }

    public CustomerDTO fallbackRetrieveCustomer(String cstmId, Throwable t) throws Exception {
        String msg = "restTemplate를 이용하여 " + cstmId + " 고객정보 조회 서비스 호출에 문제가 있습니다.";
        log.error(msg,t);
        throw new Exception();
    }





}
