package com.company.dto.requests;

import com.company.entities.BookStatus;

public record UpdateBookCopyRequest(Long bookCopyId, BookStatus status) {
}
