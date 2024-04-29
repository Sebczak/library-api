package com.company.dto.responses;

import java.time.LocalDate;

public record ReaderResponse(Long readerId, String firstname, String lastname, LocalDate accountCreationDate) {

}
