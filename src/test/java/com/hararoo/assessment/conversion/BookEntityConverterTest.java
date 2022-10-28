package com.hararoo.assessment.conversion;

import com.hararoo.assessment.dto.BookDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

@DisplayName("Unit Tests - BookEntityConverterTest")
public class BookEntityConverterTest {

    @InjectMocks
    BookEntityConverter bookEntityConverter;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Test - testBooKDTO Converter when Book Entity is not null")
    @Test
    public void testConvert() {
        var bookDTO = BookDTO.builder().isbn(1234).build();
        var bookEntity = bookEntityConverter.apply(bookDTO);

        Assertions.assertNotNull(bookEntity);
        Assertions.assertEquals(bookEntity.getIsbn(), bookDTO.getIsbn());
    }

    @DisplayName("Test - testBooKDTO Converter when Book Entity is null")
    @Test
    public void testConvert1() {
        var bookEntity = bookEntityConverter.apply(null);

        Assertions.assertNull(bookEntity);
    }
}
