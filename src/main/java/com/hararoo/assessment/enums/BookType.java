package com.hararoo.assessment.enums;

public enum BookType {

    FICTION ("FICTION"),
    COMIC ("COMIC"),
    SPIRITUAL ("SPIRITUAL"),
    COMPUTER ("COMPUTER");

    private final String value;
    BookType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
