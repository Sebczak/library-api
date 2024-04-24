package com.company.domains;

import com.company.entities.BookStatus;

public record UpdateBookCopy(Long bookCopyId, BookStatus status) {
}
