package com.tutorial.tutorial1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cars")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String brand;
    private String color;
    @Column(name = "year_of_manufacture") // Use an alternative column name
    private String year;
    private String chassieNumber;
    private String engineNumber;
    private int engineCapacity;
    private String fuelType;
}
