package com.company.services;

import com.company.dto.requests.AddBookRentRequest;
import com.company.dto.requests.BookRentReturnRequest;
import com.company.dto.responses.BookRentResponse;
import com.company.entities.*;
import com.company.mappers.BookRentMapper;
import com.company.repositories.BookCopyRepository;
import com.company.repositories.BookRentRepository;
import com.company.repositories.ReaderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BookRentServiceTest {

    @InjectMocks
    private BookRentService bookRentService;
    @Mock
    private BookRentRepository bookRentRepository;
    @Mock
    private BookCopyRepository bookCopyRepository;
    @Mock
    private ReaderRepository readerRepository;
    @Mock
    private BookRentMapper bookRentMapper;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bookRentService = new BookRentService(bookRentRepository, bookCopyRepository, readerRepository, bookRentMapper);
    }

    @Test
    void shouldAddBookRent() {
        // Given
        AddBookRentRequest request = new AddBookRentRequest(1L, 1L);
        BookCopy bookCopy = new BookCopy(1L, new BookTitle("Test Book", "Test Author", LocalDate.now()), BookStatus.AVAILABLE);
        Reader reader = new Reader("John", "Doe");
        when(bookRentRepository.save(any(BookRent.class))).thenReturn(new BookRent());
        when(bookRentMapper.mapToBookRentResponse(any(BookRent.class))).thenReturn(new BookRentResponse(1L, 1L, LocalDate.now(), LocalDate.now().plusDays(14)));
        when(bookCopyRepository.findById(1L)).thenReturn(Optional.of(bookCopy));
        when(readerRepository.findById(1L)).thenReturn(Optional.of(reader));

        // When
        BookRentResponse addedRent = bookRentService.addBookRent(request);

        // Then
        assertThat(addedRent).isNotNull();
        assertEquals(BookStatus.RENTED,bookCopy.getStatus());
    }

    @Test
    void returnBookCopy() {
        // Given
        BookRentReturnRequest request = new BookRentReturnRequest(1L);
        BookCopy bookCopy = new BookCopy(1L, new BookTitle("Test Book", "Test Author", LocalDate.now()), BookStatus.RENTED);
        BookRent bookRent = new BookRent(1L, bookCopy, new Reader("John", "Doe"),false, LocalDate.now(), LocalDate.now().plusDays(14));
        when(bookRentRepository.findById(1L)).thenReturn(Optional.of(bookRent));
        when(bookRentRepository.save(any(BookRent.class))).thenReturn(new BookRent());
        when(bookRentMapper.mapToBookRentResponse(any(BookRent.class))).thenReturn(new BookRentResponse(1L, 1L, LocalDate.now(), LocalDate.now().plusDays(14)));

        // When
        BookRentResponse addedRent = bookRentService.returnBookCopy(request);

        // Then
        assertThat(addedRent).isNotNull();
        assertEquals(BookStatus.AVAILABLE,bookCopy.getStatus());
    }
}