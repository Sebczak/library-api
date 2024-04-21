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
public class BookTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookTitleId;
    private String title;
    private String author;
    private LocalDate publishDate;
}
