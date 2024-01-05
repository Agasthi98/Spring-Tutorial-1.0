package com.tutorial.tutorial1.repository;

import com.tutorial.tutorial1.entity.Car;
import com.tutorial.tutorial1.model.CarDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<CarDto> findAllByOrderByIdDesc();
}
