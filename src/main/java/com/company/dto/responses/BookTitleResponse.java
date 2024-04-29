package com.company.dto.responses;

import java.time.LocalDate;

public record BookTitleResponse(Long bookTitleId, String title, String author, LocalDate publishDate) {
}
