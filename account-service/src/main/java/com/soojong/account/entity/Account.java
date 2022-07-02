package com.soojong.account.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Account {

    @Id
    @Column(name = "ACCOUNT_ID")
    private Long id;



}
