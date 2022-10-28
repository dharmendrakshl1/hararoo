package com.hararoo.assessment.controller;

import com.hararoo.assessment.dto.BookDTO;
import com.hararoo.assessment.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/book/service")
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    @PostMapping("/add")
    public BookDTO addBook(@RequestBody final BookDTO bookDTO) {
        return bookServiceImpl.saveOrUpdate(bookDTO);
    }

    @PutMapping("/update")
    public BookDTO updateBook(@RequestBody final BookDTO bookDTO) {
        return bookServiceImpl.saveOrUpdate(bookDTO);
    }

    @GetMapping("/listall")
    public List<BookDTO> getAllBook() {
        return bookServiceImpl.findAllBook();
    }

    @GetMapping("/isbn/{isbn}")
    public BookDTO getBookByISBN(@PathVariable("isbn") final long isbn) {
        return bookServiceImpl.findBookByISBN(isbn);
    }

    @DeleteMapping("/isbn/{isbn}")
    public void deleteBookByISBN(@PathVariable("isbn") final long isbn) {
        bookServiceImpl.deleteBookByISBN(isbn);
    }
}
