package com.company.dto;

import java.time.LocalDate;

public record ReaderDto(String firstname, String lastname, LocalDate accountCreationDate) {
}
