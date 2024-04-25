package com.company.controllers;

import com.company.dto.requests.AddBookCopy;
import com.company.dto.requests.FindBookCopyByStatus;
import com.company.dto.requests.UpdateBookCopy;
import com.company.dto.BookCopyDto;
import com.company.entities.BookCopy;
import com.company.entities.BookTitle;
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
    public List<BookCopyDto> getBookCopy() {
        List<BookCopy> bookCopies = bookCopyService.getAllBookCopies();
        return bookCopyMapper.mapToBookCopyDtoList(bookCopies);
    }

    @GetMapping("/status_count")
    public Long getBookCopyStatusCount(@RequestBody FindBookCopyByStatus findBookCopyByStatus) {

        return bookCopyService.countBookCopyByTitle(findBookCopyByStatus.status(), findBookCopyByStatus.title());
    }

    @PostMapping
    public BookCopyDto createBookCopy(@RequestBody AddBookCopy addBookCopy) {
        BookTitle bookTitle = bookTitleService.findBookTitle(addBookCopy.bookTitleId());
        BookCopy bookCopy = new BookCopy(bookTitle, addBookCopy.status());

        bookCopyRepository.save(bookCopy);
        return bookCopyMapper.mapToBookCopyDto(bookCopy);
    }

    @PutMapping
    public BookCopyDto updateBookCopyStatus(@RequestBody UpdateBookCopy updateBookCopy) {
        BookCopy bookCopy = bookCopyService.getBookCopy(updateBookCopy.bookCopyId());

        bookCopy.setStatus(updateBookCopy.status());

        bookCopyRepository.save(bookCopy);
        return bookCopyMapper.mapToBookCopyDto(bookCopy);
    }
}
