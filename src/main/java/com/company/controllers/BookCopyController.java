package com.company.controllers;

import com.company.dto.requests.CreateBookCopyRequest;
import com.company.dto.requests.FindBookCopyByStatus;
import com.company.dto.requests.UpdateBookCopyRequest;
import com.company.dto.responses.BookCopyResponse;
import com.company.services.BookCopyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/v1/book_copy")
@CrossOrigin("*")
public class BookCopyController {

    private final BookCopyService bookCopyService;

    public BookCopyController(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    @GetMapping
    public List<BookCopyResponse> getBookCopy() {
        return bookCopyService.getAllBookCopies();
    }

    @GetMapping("/status_count")
    public Long getBookCopyStatusCount(@RequestBody FindBookCopyByStatus findBookCopyByStatus) {
        return bookCopyService.countBookCopyByTitle(findBookCopyByStatus.status(), findBookCopyByStatus.title());
    }

    @PostMapping
    public BookCopyResponse createBookCopy(@RequestBody CreateBookCopyRequest createBookCopyRequest) {
        return bookCopyService.createBookCopy(createBookCopyRequest);
    }

    @PutMapping
    public BookCopyResponse updateBookCopyStatus(@RequestBody UpdateBookCopyRequest updateBookCopyRequest) {
        return bookCopyService.updateBookCopyStatus(updateBookCopyRequest);
    }
}
