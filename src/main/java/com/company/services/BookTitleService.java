package com.company.services;

import com.company.dtos.BookTitleDto;
import com.company.entities.BookTitle;
import com.company.mappers.BookTitleMapper;
import com.company.repositories.BookTitleRepository;
import org.springframework.stereotype.Service;

@Service
public class BookTitleService {

    private final BookTitleRepository bookTitleRepository;
    private final BookTitleMapper bookTitleMapper;

    public BookTitleService(BookTitleRepository bookTitleRepository, BookTitleMapper bookTitleMapper) {
        this.bookTitleRepository = bookTitleRepository;
        this.bookTitleMapper = bookTitleMapper;
    }

    public void saveBookTitle(BookTitleDto bookTitleDto) {
        BookTitle bookTitle = bookTitleMapper.mapToBookTitle(bookTitleDto);
        bookTitleRepository.save(bookTitle);
    }
}
