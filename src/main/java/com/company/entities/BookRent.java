package com.company.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table
public class BookRent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentId;
    @ManyToOne
    @JoinColumn(name = "bookCopyId")
    private BookCopy bookCopy;
    @ManyToOne
    @JoinColumn(name = "readerId")
    private Reader reader;
    private LocalDate rentalDate;
    private LocalDate returnDate;
}
