package com.hararoo.assessment.service;

import com.hararoo.assessment.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> findAllBook();
    BookDTO findBookByISBN(long isbn);
    BookDTO saveOrUpdate(BookDTO bookDTO);
    void deleteBookByISBN(long isbn);
}
