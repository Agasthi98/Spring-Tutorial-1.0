package com.tutorial.tutorial1.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OwnerDto {

    private String name;
    @Column(length = 10)
    private String phoneNumber;
    private String email;
    @Column(length = 10)
    private String nic;
    private String membershipNumber;
    private String carNo;
}
