package com.company.dto.requests;

import java.math.BigDecimal;

public record BookRentReturnRequest(Long bookRentId, BigDecimal bookFee) {

    public BookRentReturnRequest(Long bookRentId) {
        this(bookRentId, null);
    }
    }
