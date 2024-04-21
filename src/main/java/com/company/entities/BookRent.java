package com.company.entities;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class BookRent {

    private Long bookCopyId;
    private Long readerId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
}
