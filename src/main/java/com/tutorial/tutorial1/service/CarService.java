package com.tutorial.tutorial1.service;

import com.tutorial.tutorial1.entity.Car;
import com.tutorial.tutorial1.model.CarDto;
import com.tutorial.tutorial1.model.response.BaseDetailsResponse;
import com.tutorial.tutorial1.repository.CarRepository;
import com.tutorial.tutorial1.utils.GenerateNumbersUtil;
import com.tutorial.tutorial1.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class CarService {

    private final CarRepository carRepository;
    private final GenerateNumbersUtil generateNumbersUtil;

    public CarService(CarRepository carRepository, GenerateNumbersUtil generateNumbersUtil) {
        this.carRepository = carRepository;
        this.generateNumbersUtil = generateNumbersUtil;
    }

    public BaseDetailsResponse<Car> addCar(Car car) {
        String chassieNumber = car.getChassieNumber();
        String engineNumber = car.getEngineNumber();
        car.setChassieNumber(generateNumbersUtil.formatChassieNumber(chassieNumber));
        car.setEngineNumber("EG-" + engineNumber);

        try {
            Car response = carRepository.save(car); 

            log.info("Car added successfully" + response);

            return BaseDetailsResponse.<Car>builder()
                    .code(ResponseUtil.SUCCESS_CODE)
                    .title(ResponseUtil.SUCCESS)
                    .message("Car added successfully")
                    .data(response)
                    .build();

        } catch (Exception e) {
            log.error("addCar-> Exception: " + e.getMessage(), e);
            return null;
        }
    }

    public BaseDetailsResponse<HashMap<String, Object>> getCarsList() {
        try {
            List<CarDto> carList = carRepository.findAllByOrderByIdDesc();
            HashMap<String, Object> data = new HashMap<>();
            data.put("cars", carList);

            return BaseDetailsResponse.<HashMap<String, Object>>builder()
                    .code(ResponseUtil.SUCCESS_CODE)
                    .title(ResponseUtil.SUCCESS)
                    .message("Get cars list success")
                    .data(data)
                    .build();

        } catch (Exception e) {
            log.error("getCarsList-> Exception: " + e.getMessage(), e);
            return null;
        }

    }

}
