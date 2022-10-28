package com.hararoo.assessment.service;

import com.hararoo.assessment.dto.CheckOutDTO;

import java.math.BigDecimal;

public interface CalculateService {
    BigDecimal calculateTotal(CheckOutDTO checkOutDTO);
}
