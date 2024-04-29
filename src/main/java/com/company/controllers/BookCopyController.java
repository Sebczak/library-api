package com.company.controllers;

import com.company.dto.requests.AddBookCopyRequest;
import com.company.dto.requests.FindBookCopyByStatus;
import com.company.dto.requests.UpdateBookCopyRequest;
import com.company.dto.responses.BookCopyResponse;
import com.company.entities.BookCopy;
import com.company.mappers.BookCopyMapper;
import com.company.repositories.BookCopyRepository;
import com.company.services.BookCopyService;
import com.company.services.BookTitleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/v1/book_copy")
public class BookCopyController {

    private final BookCopyService bookCopyService;
    private final BookTitleService bookTitleService;
    private final BookCopyMapper bookCopyMapper;
    private final BookCopyRepository bookCopyRepository;

    public BookCopyController(BookCopyService bookCopyService, BookTitleService bookTitleService, BookCopyMapper bookCopyMapper, BookCopyRepository bookCopyRepository) {
        this.bookCopyService = bookCopyService;
        this.bookTitleService = bookTitleService;
        this.bookCopyMapper = bookCopyMapper;
        this.bookCopyRepository = bookCopyRepository;
    }

    @GetMapping
    public List<BookCopyResponse> getBookCopy() {
        List<BookCopy> bookCopies = bookCopyService.getAllBookCopies();
        return bookCopyMapper.mapToBookCopyDtoList(bookCopies);
    }

    @GetMapping("/status_count")
    public Long getBookCopyStatusCount(@RequestBody FindBookCopyByStatus findBookCopyByStatus) {

        return bookCopyService.countBookCopyByTitle(findBookCopyByStatus.status(), findBookCopyByStatus.title());
    }

    @PostMapping
    public BookCopyResponse createBookCopy(@RequestBody AddBookCopyRequest addBookCopyRequest) {
        BookCopy bookCopy = bookCopyService.createBookCopy(addBookCopyRequest);

        return bookCopyMapper.mapToBookCopyResponse(bookCopy);
    }

    @PutMapping
    public BookCopyResponse updateBookCopyStatus(@RequestBody UpdateBookCopyRequest updateBookCopyRequest) {
        BookCopy bookCopy = bookCopyService.updateBookCopyStatus(updateBookCopyRequest);

        return bookCopyMapper.mapToBookCopyResponse(bookCopy);
    }
}
