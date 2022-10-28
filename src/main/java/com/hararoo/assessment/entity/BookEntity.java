package com.hararoo.assessment.entity;

import com.hararoo.assessment.enums.BookType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BookEntity {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private long isbn;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String author;
    @Column
    @Enumerated(EnumType.STRING)
    private BookType type;
    @Column
    private BigDecimal price;

}
