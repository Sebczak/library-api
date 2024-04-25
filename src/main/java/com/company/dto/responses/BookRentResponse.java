package com.company.dto.responses;

import java.time.LocalDate;

public record BookRentResponse(Long bookCopyId, Long readerId, LocalDate rentalDate, LocalDate returnDate) {
}
