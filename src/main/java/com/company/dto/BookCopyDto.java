package com.company.dto;

import com.company.entities.BookStatus;
import com.company.entities.BookTitle;

public record BookCopyDto(Long bookCopyId, BookTitle bookTitle, BookStatus status) {
}
