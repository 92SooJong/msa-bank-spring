package com.soojong.customer.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Customer {

    @Id
    @Column(name = "CUSTOMER_ID")
    private Long id;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "CUSTOMER_AGE")
    private int customerAge;

    @Column(name = "CUSTOMER_GRADE")
    private String customerGrade;

    @Column(name = "CUSTOMER_ADDRESS")
    private String customerAddress;



}
