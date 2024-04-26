package com.company.services;

import com.company.dto.requests.AddBookRentRequest;
import com.company.dto.requests.BookRentReturnRequest;
import com.company.entities.BookCopy;
import com.company.entities.BookRent;
import com.company.entities.BookStatus;
import com.company.entities.Reader;
import com.company.repositories.BookCopyRepository;
import com.company.repositories.BookRentRepository;
import com.company.repositories.ReaderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

        if (bookCopy.getStatus() != BookStatus.AVAILABLE) {
            throw new IllegalStateException("Book copy status is not AVAILABLE");
        }

        BookRent bookRent = new BookRent();
        bookRent.setBookCopy(bookCopy);
        bookRent.setReader(reader);
        bookRent.setRentalDate(LocalDate.now());
        bookRent.setReturnDate(LocalDate.now().plusDays(14));
        bookCopy.setStatus(BookStatus.RENTED);

        return bookRentRepository.save(bookRent);
    }

    public BookRent returnBookCopy(BookRentReturnRequest bookRentReturnRequest) {
        BookRent bookRent = bookRentRepository.findById(bookRentReturnRequest.bookRentId()).orElseThrow(() -> new IllegalStateException("Book Rent not found"));

        LocalDate todayDate = LocalDate.now();
        System.out.println(todayDate);
        System.out.println(bookRent.getReturnDate());
        if (bookRent.isBookCopyReturned() == true) {
            throw new IllegalStateException("Book is already returned");
        } else {
            if (bookRent.getReturnDate().isBefore(todayDate)) {
                if (bookRentReturnRequest.bookFee() != null || bookRentReturnRequest.bookFee().compareTo(BigDecimal.TEN) < 10) {
                    throw new IllegalStateException("Return date is greater than current date, please pay the fee. Free is 10$");
                } else {
                    bookRent.setBookCopyReturned(true);
                    System.out.println("Fee payed successfully");
                }
            }
        }
        bookRent.setBookCopyReturned(true);
        bookRent.getBookCopy().setStatus(BookStatus.AVAILABLE);


        return bookRentRepository.save(bookRent);
    }
}
