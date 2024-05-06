package com.company.controllers;

import com.company.dto.requests.CreateBookTitleRequest;
import com.company.dto.responses.BookTitleResponse;
import com.company.services.BookTitleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("library/v1/book")
@CrossOrigin("*")
public class BookTitleController {

    private final BookTitleService bookTitleService;

    public BookTitleController(BookTitleService bookTitleService) {
        this.bookTitleService = bookTitleService;
    }

    @PostMapping
    public BookTitleResponse createBookTitle(@RequestBody CreateBookTitleRequest createBookTitleRequest) {
        return bookTitleService.saveBookTitle(createBookTitleRequest);
    }
}
