package com.company.dto.requests;

import com.company.entities.BookStatus;

public record UpdateBookCopy(Long bookCopyId, BookStatus status) {
}
