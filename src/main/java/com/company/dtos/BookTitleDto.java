package com.company.dtos;

import java.time.LocalDate;

public record BookTitleDto(String title, String author, LocalDate publishDate) {
}
