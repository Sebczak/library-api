package com.company.dto.responses;

import java.time.LocalDate;

public record BookTitleResponse(String title, String author, LocalDate publishDate) {
}
