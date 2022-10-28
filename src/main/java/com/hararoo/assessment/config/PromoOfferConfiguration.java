package com.hararoo.assessment.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "promo")
public class PromoOfferConfiguration {
    private List<Map<String, Map<String, Integer>>> offers;

    public Map<String, Integer> getOfferMapBasedOnOfferCode(final String offerCode) {
        return Optional
                .ofNullable(offerCode)
                .flatMap(code -> offers
                        .stream()
                        .filter(map -> map.containsKey(offerCode))
                        .map(map -> map.get(offerCode))
                        .findFirst())
                .orElse(null)
                ;
    }
}
