package com.hararoo.assessment.dto;

import lombok.*;

import java.util.List;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class CheckOutDTO {
    private String offerCode;
    private List<BookDTO> bookList;
}
