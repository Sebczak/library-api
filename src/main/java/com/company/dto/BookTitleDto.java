package com.company.dto;

import java.time.LocalDate;

public record BookTitleDto(String title, String author, LocalDate publishDate) {
}
