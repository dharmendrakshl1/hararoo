package com.hararoo.assessment.service;

import com.hararoo.assessment.conversion.BookDTOConverter;
import com.hararoo.assessment.conversion.BookEntityConverter;
import com.hararoo.assessment.dto.BookDTO;
import com.hararoo.assessment.entity.BookEntity;
import com.hararoo.assessment.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

@DisplayName("Unit Tests - BookServiceImplTest")
public class BookServiceImplTest {

    @InjectMocks
    BookServiceImpl bookService;

    @Mock
    BookRepository bookRepository;

    @Mock
    BookDTOConverter bookDTOConverter;

    @Mock
    BookEntityConverter bookEntityConverter;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Test - testFindAllBook")
    @Test
    public void testFindAllBook() {
        Mockito.when(bookRepository.findAll())
                .thenReturn(List.of(BookEntity.builder().build(), BookEntity.builder().build()));

        Mockito.when(bookDTOConverter.apply(Mockito.any(BookEntity.class)))
                .thenReturn(BookDTO.builder().build());

        var bookDTOList = bookService.findAllBook();
        Assertions.assertNotNull(bookDTOList);
        Assertions.assertEquals(2, bookDTOList.size());
    }

    @DisplayName("Test - findBookByISBN")
    @Test
    public void testFindBookByISBN() {
        Mockito.when(bookRepository.findById(1234L))
                .thenReturn(Optional.of(BookEntity.builder().isbn(1234).build()));

        Mockito.when(bookDTOConverter.apply(Mockito.any(BookEntity.class)))
                .thenReturn(BookDTO.builder().isbn(1234).build());

        var bookDTO = bookService.findBookByISBN(1234);
        Assertions.assertNotNull(bookDTO);
        Assertions.assertEquals(1234, bookDTO.getIsbn());
    }

    @DisplayName("Test - saveOrUpdate when BookDTO is not null")
    @Test
    public void testSaveOrUpdate() {
        Mockito.when(bookEntityConverter.apply(Mockito.any(BookDTO.class)))
                .thenReturn(BookEntity.builder().isbn(1234).build());

        Mockito.when(bookRepository.save(Mockito.any(BookEntity.class)))
                .thenReturn(BookEntity.builder().isbn(1234).build());

        Mockito.when(bookDTOConverter.apply(Mockito.any(BookEntity.class)))
                .thenReturn(BookDTO.builder().isbn(1234).build());

        var bookDTO = bookService.saveOrUpdate(BookDTO.builder().isbn(1234).build());
        Assertions.assertNotNull(bookDTO);
        Assertions.assertEquals(1234, bookDTO.getIsbn());
    }

    @DisplayName("Test - saveOrUpdate when BookDTO is null")
    @Test
    public void testSaveOrUpdate1() {

        var bookDTO = bookService.saveOrUpdate(null);
        Assertions.assertNull(bookDTO);
    }

    @DisplayName("Test - deleteBookByISBN")
    @Test
    public void testDeleteBookByISBN() {

        Mockito.doNothing()
                .when(bookRepository).deleteById(1234L);

        bookService.deleteBookByISBN(1234);
        Mockito.verify(bookRepository).deleteById(1234L);
    }
}
