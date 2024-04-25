package com.company.entities;

import jakarta.persistence.*;
import lombok.*;

@NamedQuery(name = "BookCopy.countByTitleAndStatus",
        query = "SELECT COUNT(bc) FROM BookCopy bc WHERE bc.bookTitle.title = :title AND bc.status = :status")
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
    @JoinColumn(name = "book_title_id")
    private BookTitle bookTitle;
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    public BookCopy(BookTitle bookTitle, BookStatus status) {
        this.bookTitle = bookTitle;
        this.status = status;
    }

    public BookCopy(BookTitle bookTitle) {
        this.bookTitle = bookTitle;
    }
}
