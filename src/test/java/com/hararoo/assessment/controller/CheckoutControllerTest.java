package com.hararoo.assessment.controller;

import com.hararoo.assessment.dto.CheckOutDTO;
import com.hararoo.assessment.service.CalculateServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@DisplayName("Unit Tests - CheckoutControllerTest")
public class CheckoutControllerTest {

    @InjectMocks
    CheckoutController checkoutController;

    @Mock
    CalculateServiceImpl calculateTotalService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test - calculateTotal")
    public void testCalculateTotal() {

        when(calculateTotalService.calculateTotal(Mockito.any(CheckOutDTO.class)))
                .thenReturn(new BigDecimal("10.45"));

        var totalAmount = checkoutController.calculateTotal(CheckOutDTO.builder().build());

        Assertions.assertNotNull(totalAmount);
        Assertions.assertEquals(new BigDecimal("10.45"), totalAmount);
    }
}
