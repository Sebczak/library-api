package com.company.domains;

import com.company.entities.BookStatus;

public record FindBookCopyByStatus(String title, BookStatus status) {
}
