package com.company.services;

import com.company.dto.requests.CreateBookCopyRequest;
import com.company.dto.requests.UpdateBookCopyRequest;
import com.company.dto.responses.BookCopyResponse;
import com.company.entities.BookCopy;
import com.company.entities.BookStatus;
import com.company.entities.BookTitle;
import com.company.mappers.BookCopyMapper;
import com.company.repositories.BookCopyRepository;
import com.company.repositories.BookTitleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyService {

    private final BookCopyRepository bookCopyRepository;
    private final BookTitleRepository bookTitleRepository;
    private final BookCopyMapper bookCopyMapper;

    public BookCopyService(BookCopyRepository bookCopyRepository, BookTitleRepository bookTitleRepository, BookCopyMapper bookCopyMapper) {
        this.bookCopyRepository = bookCopyRepository;
        this.bookTitleRepository = bookTitleRepository;
        this.bookCopyMapper = bookCopyMapper;
    }

    public List<BookCopyResponse> getAllBookCopies() {
        List<BookCopy> bookCopies = bookCopyRepository.findAll();
        return bookCopyMapper.mapToBookCopyResponseList(bookCopies);
    }

    public BookCopy updateBookCopyStatus(UpdateBookCopyRequest updateBookCopyRequest) {
        BookCopy bookCopy = bookCopyRepository.findById(updateBookCopyRequest.bookCopyId()).orElseThrow(() -> new IllegalStateException("Book Copy not found"));

        bookCopy.setStatus(updateBookCopyRequest.status());
        return bookCopyRepository.save(bookCopy);
    }

    public Long countBookCopyByTitle(BookStatus status, String title) {
        return bookCopyRepository.countByTitleAndStatus(title, status);
    }

    public BookCopy createBookCopy(CreateBookCopyRequest createBookCopyRequest) {
        BookTitle bookTitle = bookTitleRepository.findById(createBookCopyRequest.bookTitleId()).orElseThrow(() -> new IllegalStateException("Book title not found"));

        BookCopy bookCopy = new BookCopy();
        bookCopy.setBookTitle(bookTitle);
        bookCopy.setStatus(BookStatus.AVAILABLE);

        return bookCopyRepository.save(bookCopy);
    }
}
