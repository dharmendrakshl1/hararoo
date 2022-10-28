package com.hararoo.assessment.conversion;

import com.hararoo.assessment.dto.BookDTO;
import com.hararoo.assessment.entity.BookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class BookEntityConverter implements Function<BookDTO, BookEntity> {
    @Override
    public BookEntity apply(final BookDTO bookDTO) {
        return Optional
                .ofNullable(bookDTO)
                .map(book -> BookEntity
                        .builder()
                        .isbn(book.getIsbn())
                        .name(book.getName())
                        .description(book.getDescription())
                        .author(book.getAuthor())
                        .type(book.getType())
                        .price(book.getPrice())
                        .build())
                .orElse(null);
    }
}
