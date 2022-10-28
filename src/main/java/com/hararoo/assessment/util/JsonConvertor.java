package com.hararoo.assessment.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvertor<T> {

    public static <T> String convertStringFromObject(final T body) {
        final var objectMapper = new ObjectMapper();
        String json;
        try {
            json = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            json = null;
        }
        return json;
    }

    public static <T> T convertObjectFromString(final String json, final Class<T> tClass) {
        final var objectMapper = new ObjectMapper();
        T object;
        try {
           object = objectMapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            object = null;
        }

        return object;
    }
}
