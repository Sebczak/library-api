package com.company.services;

import com.company.entities.BookCopy;
import com.company.entities.BookStatus;
import com.company.repositories.BookCopyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyService {

    private final BookCopyRepository bookCopyRepository;

    public BookCopyService(BookCopyRepository bookCopyRepository) {
        this.bookCopyRepository = bookCopyRepository;
    }

    public List<BookCopy> getAllBookCopies() {
        return bookCopyRepository.findAll();
    }

    public void addBookCopy(BookCopy bookCopy) {
        bookCopyRepository.save(bookCopy);
    }

    public BookCopy getBookCopy(Long bookCopyId) {
        return bookCopyRepository.findById(bookCopyId).orElseThrow(() -> new IllegalStateException("Book copy id not found"));
    }

    public Long countBookCopyByTitle(BookStatus status, String title) {
        return bookCopyRepository.countByTitleAndStatus(title, status);
    }
}
