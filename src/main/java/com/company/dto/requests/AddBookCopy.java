package com.company.dto.requests;

import com.company.entities.BookStatus;

public record AddBookCopy(Long bookTitleId, BookStatus status) {
}
