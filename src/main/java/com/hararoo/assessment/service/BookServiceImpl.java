package com.hararoo.assessment.service;

import com.hararoo.assessment.conversion.BookDTOConverter;
import com.hararoo.assessment.conversion.BookEntityConverter;
import com.hararoo.assessment.dto.BookDTO;
import com.hararoo.assessment.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    @Autowired
    private final BookRepository bookRepository;
    private final BookDTOConverter bookDTOConverter;
    private final BookEntityConverter bookEntityConverter;

    @Override
    public List<BookDTO> findAllBook() {
       return Optional
               .of(bookRepository.findAll())
               .orElseGet(Collections::emptyList)
                .stream()
                .map(bookDTOConverter)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO findBookByISBN(long isbn) {
        return bookRepository
                .findById(isbn)
                .map(bookDTOConverter)
                .orElseGet(BookDTO::new);
    }

    @Override
    public BookDTO saveOrUpdate(BookDTO bookDTO) {
        return Optional
                .ofNullable(bookDTO)
                .map(bookEntityConverter)
                .map(bookRepository::save)
                .map(bookDTOConverter)
                .orElse(null);
    }

    @Override
    public void deleteBookByISBN(long isbn) {
        bookRepository
                .deleteById(isbn);
    }
}
