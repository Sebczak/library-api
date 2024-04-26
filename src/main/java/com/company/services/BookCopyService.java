package com.company.services;

import com.company.dto.requests.AddBookCopy;
import com.company.dto.requests.UpdateBookCopy;
import com.company.entities.BookCopy;
import com.company.entities.BookStatus;
import com.company.entities.BookTitle;
import com.company.repositories.BookCopyRepository;
import com.company.repositories.BookTitleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyService {

    private final BookCopyRepository bookCopyRepository;
    private final BookTitleRepository bookTitleRepository;

    public BookCopyService(BookCopyRepository bookCopyRepository, BookTitleRepository bookTitleRepository) {
        this.bookCopyRepository = bookCopyRepository;
        this.bookTitleRepository = bookTitleRepository;
    }

    public List<BookCopy> getAllBookCopies() {
        return bookCopyRepository.findAll();
    }

    public BookCopy updateBookCopyStatus(UpdateBookCopy updateBookCopy) {
        BookCopy bookCopy = bookCopyRepository.findById(updateBookCopy.bookCopyId()).orElseThrow(() -> new IllegalStateException("Book Copy not found"));

        bookCopy.setStatus(updateBookCopy.status());
        return bookCopyRepository.save(bookCopy);
    }

    public Long countBookCopyByTitle(BookStatus status, String title) {
        return bookCopyRepository.countByTitleAndStatus(title, status);
    }

    public BookCopy createBookCopy(AddBookCopy addBookCopy) {
        BookTitle bookTitle = bookTitleRepository.findById(addBookCopy.bookTitleId()).orElseThrow(() -> new IllegalStateException("Book title not found"));

        BookCopy bookCopy = new BookCopy();
        bookCopy.setBookTitle(bookTitle);
        bookCopy.setStatus(BookStatus.AVAILABLE);

        return bookCopyRepository.save(bookCopy);
    }
}
