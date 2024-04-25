package com.company.services;

import com.company.dto.requests.AddBookRentRequest;
import com.company.entities.BookCopy;
import com.company.entities.BookRent;
import com.company.entities.Reader;
import com.company.repositories.BookCopyRepository;
import com.company.repositories.BookRentRepository;
import com.company.repositories.ReaderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookRentService {

    private final BookRentRepository bookRentRepository;
    private final BookCopyRepository bookCopyRepository;
    private final ReaderRepository readerRepository;

    public BookRentService(BookRentRepository bookRentRepository, BookCopyRepository bookCopyRepository, ReaderRepository readerRepository) {
        this.bookRentRepository = bookRentRepository;
        this.bookCopyRepository = bookCopyRepository;
        this.readerRepository = readerRepository;
    }

    public BookRent addBookRent(AddBookRentRequest bookRentRequest) {
        BookCopy bookCopy = bookCopyRepository.findById(bookRentRequest.bookCopyId()).orElseThrow(() -> new IllegalStateException("Book copy not found"));
        Reader reader = readerRepository.findById(bookRentRequest.readerId()).orElseThrow(() -> new IllegalStateException("Reader not found"));

        BookRent bookRent = new BookRent();
        bookRent.setBookCopy(bookCopy);
        bookRent.setReader(reader);
        bookRent.setRentalDate(LocalDate.now());
        bookRent.setReturnDate(LocalDate.now().plusDays(14));

        return bookRentRepository.save(bookRent);
    }
}
