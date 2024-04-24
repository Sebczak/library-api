package com.company.domains;

import com.company.entities.BookStatus;

public record AddBookCopy(Long bookTitleId, BookStatus status) {
}
