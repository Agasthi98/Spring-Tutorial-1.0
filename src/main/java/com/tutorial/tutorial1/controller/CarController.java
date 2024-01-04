package com.tutorial.tutorial1.controller;

import com.tutorial.tutorial1.entity.Car;
import com.tutorial.tutorial1.model.response.BaseDetailsResponse;
import com.tutorial.tutorial1.model.response.DefaultResponse;
import com.tutorial.tutorial1.service.CarService;
import com.tutorial.tutorial1.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/cars")
@Slf4j
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> addCars(@RequestBody Car car) {
        BaseDetailsResponse<Car> response = carService.addCar(car);

        if (response.getCode().equals(ResponseUtil.SUCCESS_CODE)) {
            return ResponseEntity.ok(DefaultResponse.success(ResponseUtil.SUCCESS, response.getMessage(), response.getData()));
        } else if (response.getCode().equals(ResponseUtil.INTERNAL_SERVER_ERROR_CODE)) {
            return ResponseEntity.internalServerError().body(DefaultResponse.internalServerError(ResponseUtil.INTERNAL_SERVER_ERROR_CODE, response.getMessage()));

        }
        else{
            return ResponseEntity.badRequest().body(DefaultResponse.error(ResponseUtil.FAILED, response.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<DefaultResponse> getCarsList(){
        BaseDetailsResponse<HashMap<String, Object>> response = carService.getCarsList();
        if (response.getCode().equals(ResponseUtil.SUCCESS_CODE)) {
            return ResponseEntity.ok(DefaultResponse.success(ResponseUtil.SUCCESS, response.getMessage(), response.getData()));
        } else if (response.getCode().equals(ResponseUtil.INTERNAL_SERVER_ERROR_CODE)) {
            return ResponseEntity.internalServerError().body(DefaultResponse.internalServerError(ResponseUtil.INTERNAL_SERVER_ERROR_CODE, response.getMessage()));

        }
        else{
            return ResponseEntity.badRequest().body(DefaultResponse.error(ResponseUtil.FAILED, response.getMessage()));
        }
    }

}
