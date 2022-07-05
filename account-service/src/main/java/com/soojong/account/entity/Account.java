package com.soojong.account.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Account {

    @Id
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @Column(name ="CUSTOMER_ID")
    private Long customerId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "ACCOUNT_BALANCE")
    private int balance;

}
