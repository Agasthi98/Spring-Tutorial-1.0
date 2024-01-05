package com.tutorial.tutorial1.controller;

import com.tutorial.tutorial1.entity.Car;
import com.tutorial.tutorial1.entity.Owner;
import com.tutorial.tutorial1.model.response.BaseDetailsResponse;
import com.tutorial.tutorial1.model.response.DefaultResponse;
import com.tutorial.tutorial1.service.OwnerService;
import com.tutorial.tutorial1.utils.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> addOwner(@RequestBody Owner owner) {
        BaseDetailsResponse<Owner> response = ownerService.addOwner(owner);

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
