package com.company.dto.requests;

import java.time.LocalDate;

public record CreateBookTitleRequest(String title, String author, LocalDate publicationDate) {
}
