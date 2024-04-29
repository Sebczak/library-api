package com.company.services;

import com.company.dto.requests.CreateBookTitleRequest;
import com.company.dto.responses.BookTitleResponse;
import com.company.dto.responses.ReaderResponse;
import com.company.entities.BookTitle;
import com.company.entities.Reader;
import com.company.mappers.BookTitleMapper;
import com.company.repositories.BookTitleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BookTitleServiceTest {

    @InjectMocks
    private BookTitleService bookTitleService;
    @Mock
    private BookTitleRepository bookTitleRepository;
    @Mock
    private BookTitleMapper bookTitleMapper;
    private CreateBookTitleRequest createBookTitleRequest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bookTitleService = new BookTitleService(bookTitleRepository, bookTitleMapper);
        createBookTitleRequest = new CreateBookTitleRequest("test", "test", LocalDate.now());
    }
    @Test
    void saveBookTitle() {
        //Given
        when(bookTitleMapper.mapToBookTitleResponse(any(BookTitle.class))).thenReturn(new BookTitleResponse(999L, createBookTitleRequest.title(), createBookTitleRequest.author(), LocalDate.now()));
        when(bookTitleRepository.save(any(BookTitle.class))).thenReturn(new BookTitle());

        //When
        BookTitleResponse bookTitleResponse = bookTitleService.saveBookTitle(createBookTitleRequest);

        //Then
        assertThat(bookTitleResponse.title()).isEqualTo("test");
    }
}