package com.company.dto.requests;

import com.company.entities.BookStatus;

public record FindBookCopyByStatus(String title, BookStatus status) {
}
