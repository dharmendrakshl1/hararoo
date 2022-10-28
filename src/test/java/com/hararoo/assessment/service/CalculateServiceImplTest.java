package com.hararoo.assessment.service;

import com.hararoo.assessment.config.PromoOfferConfiguration;
import com.hararoo.assessment.dto.BookDTO;
import com.hararoo.assessment.dto.CheckOutDTO;
import com.hararoo.assessment.enums.BookType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@DisplayName("Unit Tests - BookServiceImplTest")
public class CalculateServiceImplTest {
    @InjectMocks
    CalculateServiceImpl calculateService;

    @Mock
    PromoOfferConfiguration promoOfferConfiguration;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(promoOfferConfiguration.getOfferMapBasedOnOfferCode("offercode1"))
                .thenReturn(Map.of("COMIC", 5, "FICTION", 10));

    }

    @DisplayName("Test - calculate total when bookList is empty")
    @Test
    public void testWhenBookListIsEmpty() {
        var checkDTO = CheckOutDTO.builder().offerCode("offercode1").build();
        var totalAmount = calculateService.calculateTotal(checkDTO);

        Assertions.assertNotNull(totalAmount);
        Assertions.assertEquals(BigDecimal.ZERO, totalAmount);
    }

    @DisplayName("Test - calculate total when bookList is not empty and offer code is present")
    @Test
    public void testWhenBookListIsNotEmpty() {
        var checkDTO = CheckOutDTO.builder()
                .offerCode("offercode1")
                .bookList(List.of(BookDTO.builder().type(BookType.COMIC).price(new BigDecimal(100)).build(),
                        BookDTO.builder().type(BookType.FICTION).price(new BigDecimal(100)).build(),
                        BookDTO.builder().type(BookType.COMPUTER).price(new BigDecimal(100)).build()))
                .build();
        var totalAmount = calculateService.calculateTotal(checkDTO);

        Assertions.assertNotNull(totalAmount);
        Assertions.assertEquals(new BigDecimal(285), totalAmount);
    }

    @DisplayName("Test - calculate total when bookList is not empty and offer code is not present")
    @Test
    public void testWhenBookListIsNotEmpty1() {
        var checkDTO = CheckOutDTO.builder()
                .offerCode("offercode2")
                .bookList(List.of(BookDTO.builder().type(BookType.COMIC).price(new BigDecimal(100)).build(),
                        BookDTO.builder().type(BookType.FICTION).price(new BigDecimal(100)).build(),
                        BookDTO.builder().type(BookType.COMPUTER).price(new BigDecimal(100)).build()))
                .build();
        var totalAmount = calculateService.calculateTotal(checkDTO);

        Assertions.assertNotNull(totalAmount);
        Assertions.assertEquals(new BigDecimal(300), totalAmount);
    }
}
