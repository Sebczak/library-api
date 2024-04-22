package com.company.dtos;

import com.company.entities.BookStatus;

public record BookCopyDto(Long bookCopyId, Long bookTitleId, BookStatus status) {
}
