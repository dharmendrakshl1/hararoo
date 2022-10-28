package com.hararoo.assessment.controller;

import com.hararoo.assessment.dto.CheckOutDTO;
import com.hararoo.assessment.service.CalculateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/api/checkout/service")
public class CheckoutController {
    @Autowired
    CalculateServiceImpl calculateTotalServiceImpl;

    @PostMapping("/calculate/total")
    public BigDecimal calculateTotal(@RequestBody final CheckOutDTO checkOutDTO) {
        return calculateTotalServiceImpl.calculateTotal(checkOutDTO);
    }
}
