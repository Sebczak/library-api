package com.company.dto.responses;

import com.company.entities.BookStatus;
import com.company.entities.BookTitle;

public record BookCopyResponse(Long bookCopyId, BookTitle bookTitle, BookStatus status) {
}
