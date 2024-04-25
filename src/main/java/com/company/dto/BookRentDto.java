package com.company.dto;

import java.time.LocalDate;

public record BookRentDto(Long bookCopyId, Long readerId, LocalDate rentalDate, LocalDate returnDate) {
}
