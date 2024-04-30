package com.company.controllers;

import com.company.dto.requests.AddBookRentRequest;
import com.company.dto.requests.BookRentReturnRequest;
import com.company.dto.responses.BookRentResponse;
import com.company.mappers.BookRentMapper;
import com.company.services.BookRentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("library/v1/book_rent")
public class BookRentController {

    private final BookRentService bookRentService;
    private final BookRentMapper bookRentMapper;

    public BookRentController(BookRentService bookRentService, BookRentMapper bookRentMapper) {
        this.bookRentService = bookRentService;
        this.bookRentMapper = bookRentMapper;
    }

    @PostMapping
    public BookRentResponse addBookRent(@RequestBody AddBookRentRequest addBookRentRequest) {
        return bookRentService.addBookRent(addBookRentRequest);
    }

    @PutMapping
    public BookRentResponse returnBookCopy(@RequestBody BookRentReturnRequest bookRentReturnRequest) {
        return bookRentService.returnBookCopy(bookRentReturnRequest);
    }
}
