package com.company.dtos;

import java.time.LocalDate;

public record ReaderDto(String firstname, String lastname, LocalDate accountCreationDate) {
}
