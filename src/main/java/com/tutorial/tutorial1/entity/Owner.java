package com.tutorial.tutorial1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Owners")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Owner extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String nic;
    private String membershipNumber;
    private String loyaltyNumber;
    private String carNo;
}
