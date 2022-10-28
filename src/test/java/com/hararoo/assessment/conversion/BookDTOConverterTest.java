package com.hararoo.assessment.conversion;

import com.hararoo.assessment.entity.BookEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

@DisplayName("Unit Tests - BookDTOConverterTest")
public class BookDTOConverterTest {

    @InjectMocks
    BookDTOConverter bookDTOConverter;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Test - testBooKDTO Converter when Book Entity is not null")
    @Test
    public void testConvert() {
        var bookEntity = BookEntity.builder().isbn(1234).build();
        var bookDTO = bookDTOConverter.apply(bookEntity);

        Assertions.assertNotNull(bookDTO);
        Assertions.assertEquals(bookEntity.getIsbn(), bookDTO.getIsbn());
    }

    @DisplayName("Test - testBooKDTO Converter when Book Entity is null")
    @Test
    public void testConvert1() {
        var bookDTO = bookDTOConverter.apply(null);

        Assertions.assertNull(bookDTO);
    }
}
