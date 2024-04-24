package com.company.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookCopyId;
    @ManyToOne
    @JoinColumn(name = "bookTitleId")
    private BookTitle bookTitle;
    @Enumerated(EnumType.STRING)
    private BookStatus status;
}
