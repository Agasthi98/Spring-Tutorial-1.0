package com.tutorial.tutorial1.service;

import com.tutorial.tutorial1.entity.Owner;
import com.tutorial.tutorial1.model.response.BaseDetailsResponse;
import com.tutorial.tutorial1.repository.OwnerRepository;
import com.tutorial.tutorial1.utils.CarNumberGenerator;
import com.tutorial.tutorial1.utils.GenerateNumbersUtil;
import com.tutorial.tutorial1.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final GenerateNumbersUtil generateNumbersUtil;

    public OwnerService(OwnerRepository ownerRepository, GenerateNumbersUtil generateNumbersUtil, CarNumberGenerator carNumberGenerator) {
        this.ownerRepository = ownerRepository;
        this.generateNumbersUtil = generateNumbersUtil;
    }

    public BaseDetailsResponse<Owner> addOwner(Owner owner) {
        String phoneNumber = generateNumbersUtil.processPhoneNumber(owner.getPhoneNumber());
        String nic = generateNumbersUtil.maskNumber(owner.getNic());
        String carNo = CarNumberGenerator.generateRandomCarNumber();
        String memberShipNo = owner.getMembershipNumber();

        owner.setPhoneNumber(phoneNumber);
        owner.setNic(nic);
        owner.setCarNo(carNo);
        owner.setMembershipNumber("M" + memberShipNo);

        try {
            Owner response = ownerRepository.save(owner);
            log.info("Owner added successfully" + response);

            return BaseDetailsResponse.<Owner>builder()
                    .code(ResponseUtil.SUCCESS_CODE)
                    .title(ResponseUtil.SUCCESS)
                    .message("Owner added successfully")
                    .data(response)
                    .build();

        } catch (Exception e) {
            log.error("addOwner-> Exception: " + e.getMessage(), e);
            return null;
        }
    }
}
