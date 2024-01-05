package com.tutorial.tutorial1.repository;

import com.tutorial.tutorial1.entity.Car;
import com.tutorial.tutorial1.entity.Owner;
import com.tutorial.tutorial1.model.OwnerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    List<OwnerDto> findAllByOrderByIdDesc();
}
