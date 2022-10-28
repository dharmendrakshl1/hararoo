package com.hararoo.assessment.controller;

import com.hararoo.assessment.dto.BookDTO;
import com.hararoo.assessment.enums.BookType;
import com.hararoo.assessment.service.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

@DisplayName("Unit Tests - BookControllerTest")
public class BookControllerTest {

    @InjectMocks
    BookController bookController;

    @Mock
    BookServiceImpl bookService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test - addBook")
    public void testAddBook() {

        var bookDTO = BookDTO
                .builder()
                .isbn(123456)
                .name("Five Points Someone")
                .type(BookType.FICTION)
                .build();

        when(bookService.saveOrUpdate(bookDTO))
                .thenReturn(bookDTO);

        var bookDTO1 = bookController.addBook(bookDTO);

        Assertions.assertNotNull(bookDTO1);
        Assertions.assertEquals(bookDTO, bookDTO1);
    }

    @Test
    @DisplayName("Test - updateBook")
    public void testUpdateBook() {

        var bookDTO = BookDTO
                .builder()
                .isbn(123456)
                .name("Five Points Someone")
                .type(BookType.FICTION)
                .build();

        when(bookService.saveOrUpdate(bookDTO))
                .thenReturn(bookDTO);

        var bookDTO1 = bookController.updateBook(bookDTO);

        Assertions.assertNotNull(bookDTO1);
        Assertions.assertEquals(bookDTO, bookDTO1);
    }

    @Test
    @DisplayName("Test - getAllBook")
    public void testGetAllBook() {

        var bookList = List.of(BookDTO.builder().build(), BookDTO.builder().build());
        when(bookService.findAllBook())
                .thenReturn(bookList);
        var retBookList = bookController.getAllBook();

        Assertions.assertNotNull(retBookList);
        Assertions.assertFalse(retBookList.isEmpty());
        Assertions.assertEquals(bookList.size(), retBookList.size());
    }

    @Test
    @DisplayName("Test - getBookByISBN")
    public void testGetBookByISBN() {

        when(bookService.findBookByISBN(12344))
                .thenReturn(BookDTO.builder().isbn(12344).build());
        var bookDTO = bookController.getBookByISBN(12344);

        Assertions.assertNotNull(bookDTO);
        Assertions.assertEquals(12344, bookDTO.getIsbn());
    }

    @Test
    @DisplayName("Test - deleteBookByISBN")
    public void testDeleteBookByISBN() {

        Mockito
                .doNothing()
                .when(bookService)
                .deleteBookByISBN(2323);

        bookController.deleteBookByISBN(2323);
        Mockito.verify(bookService).deleteBookByISBN(2323);

    }
}
