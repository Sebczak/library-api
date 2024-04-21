package com.company.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long readerId;
    private String firstName;
    private String lastName;
    private LocalDate accountCreationDate;

    public Reader(Long readerId, String firstName, String lastName, LocalDate accountCreationDate) {
        this.readerId = readerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCreationDate = LocalDate.now();
    }

    public Reader(String firstName, String lastName, LocalDate accountCreationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCreationDate = LocalDate.now();
    }
}
