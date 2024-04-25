package com.company.dto.responses;

import java.time.LocalDate;

public record ReaderResponse(String firstname, String lastname, LocalDate accountCreationDate) {
}
