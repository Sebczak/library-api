package com.company.controllers;

import com.company.dtos.BookTitleDto;
import com.company.entities.BookTitle;
import com.company.mappers.BookTitleMapper;
import com.company.services.BookTitleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("library/v1/book")
public class BookTitleController {

    private final BookTitleMapper bookTitleMapper;
    private final BookTitleService bookTitleService;

    public BookTitleController(BookTitleMapper bookTitleMapper, BookTitleService bookTitleService) {
        this.bookTitleMapper = bookTitleMapper;
        this.bookTitleService = bookTitleService;
    }

    @PostMapping
    public Long createBookTitle(@RequestBody BookTitleDto bookTitleDto) {
        BookTitle book = bookTitleMapper.mapToBookTitle(bookTitleDto);
        bookTitleService.saveBookTitle(book);
        return book.getBookTitleId();
    }
}