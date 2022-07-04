package com.soojong.account.dto;

import lombok.Data;


@Data
public class Customer {

    private Long id;

    private String customerName;

    private int customerAge;

    private String customerGrade;

    private String customerAddress;

}
