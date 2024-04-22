package com.company.services;

import com.company.entities.BookTitle;
import com.company.repositories.BookTitleRepository;
import org.springframework.stereotype.Service;

@Service
public class BookTitleService {

    private final BookTitleRepository bookTitleRepository;

    public BookTitleService(BookTitleRepository bookTitleRepository) {
        this.bookTitleRepository = bookTitleRepository;
    }

    public void saveBookTitle(BookTitle book) {
        bookTitleRepository.save(book);
    }
}
