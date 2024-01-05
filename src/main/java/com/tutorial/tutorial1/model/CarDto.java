package com.tutorial.tutorial1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class CarDto {

    private String model;
    private String brand;
    private String color;
    private String year;
    private String chassieNumber;
    private String engineNumber;
    private int engineCapacity;
    private String fuelType;
    private String owner;
}
