package com.hararoo.assessment.service;

import com.hararoo.assessment.config.PromoOfferConfiguration;
import com.hararoo.assessment.dto.BookDTO;
import com.hararoo.assessment.dto.CheckOutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CalculateServiceImpl implements CalculateService {

    private final PromoOfferConfiguration promoOfferConfiguration;

    @Override
    public BigDecimal calculateTotal(CheckOutDTO checkOutDTO) {

       return Optional
               .ofNullable(checkOutDTO)
               .map(CheckOutDTO::getBookList)
               .orElseGet(Collections::emptyList)
               .stream()
               .map(bookDTO -> calculateDiscount(bookDTO, checkOutDTO.getOfferCode()))
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               ;
    }

    private BigDecimal calculateDiscount(final BookDTO bookDTO, final String offerCode) {
        Integer offerValue = null;
        var bookPrice = bookDTO.getPrice();
        var offerCodeMap = promoOfferConfiguration.getOfferMapBasedOnOfferCode(offerCode);
        if (null != offerCodeMap) {
            offerValue = offerCodeMap.get(bookDTO.getType().getValue());
        }

        return offerValue == null ? bookPrice
                : bookPrice.subtract((bookPrice.multiply(new BigDecimal(offerValue))).
                divide(new BigDecimal(100), RoundingMode.HALF_UP));
    }
}
