package com.hararoo.assessment.dto;

import com.hararoo.assessment.enums.BookType;
import lombok.*;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BookDTO {

    private long isbn;
    private String name;
    private String description;
    private String author;
    private BookType type;
    private BigDecimal price;
}
