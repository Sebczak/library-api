package com.company.services;

import com.company.dto.requests.CreateBookCopyRequest;
import com.company.dto.requests.UpdateBookCopyRequest;
import com.company.dto.responses.BookCopyResponse;
import com.company.entities.BookCopy;
import com.company.entities.BookStatus;
import com.company.entities.BookTitle;
import com.company.mappers.BookCopyMapper;
import com.company.repositories.BookCopyRepository;
import com.company.repositories.BookTitleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BookCopyServiceTest {

    @InjectMocks
    private BookCopyService bookCopyService;
    @Mock
    private BookCopyRepository bookCopyRepository;
    @Mock
    private BookCopyMapper bookCopyMapper;
    @Mock
    private BookTitleRepository bookTitleRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bookCopyService = new BookCopyService(bookCopyRepository, bookTitleRepository, bookCopyMapper);
    }

    @Test
    void shouldGetAllBookCopies() {
        // Given
        List<BookCopy> bookCopies = List.of(new BookCopy());
        when(bookCopyRepository.findAll()).thenReturn(bookCopies);
        when(bookCopyMapper.mapToBookCopyResponseList(any(List.class))).thenReturn(List.of(new BookCopyResponse(1L, new BookTitle("test", "test", LocalDate.now()), BookStatus.AVAILABLE)));

        // When
        List<BookCopyResponse> bookCopiesResponse = bookCopyService.getAllBookCopies();

        // Then
        assertThat(bookCopiesResponse).hasSize(1);
    }

    @Test
    void shouldUpdateBookCopyStatus() {
        // Given
        BookTitle bookTitle = new BookTitle("test", "test", LocalDate.now());
        BookCopy bookCopy = new BookCopy();
        when(bookTitleRepository.findById(1L)).thenReturn(Optional.of(bookTitle));
        when(bookCopyRepository.findById(1L)).thenReturn(Optional.of(bookCopy));
        when(bookCopyRepository.save(any(BookCopy.class))).thenReturn(new BookCopy());
        when(bookCopyMapper.mapToBookCopyResponse(any(BookCopy.class))).thenReturn(new BookCopyResponse(1L, bookTitle, BookStatus.AVAILABLE));

        // When
        BookCopyResponse bookCopyResponse = bookCopyService.updateBookCopyStatus(new UpdateBookCopyRequest(1L, BookStatus.LOST));

        //Then
        assertThat(bookCopyResponse.status()).isEqualTo(BookStatus.LOST);
    }

    @Test
    void shouldCountBookCopyByTitle() {
        // Given
        List<BookCopy> bookCopies = List.of(new BookCopy());
        when(bookCopyRepository.countByTitleAndStatus("test", BookStatus.AVAILABLE)).thenReturn(Long.valueOf(bookCopies.size()));
        when(bookCopyMapper.mapToBookCopyResponseList(any(List.class))).thenReturn(List.of(
                new BookCopyResponse(1L, new BookTitle("test", "test", LocalDate.now()), BookStatus.AVAILABLE),
                new BookCopyResponse(2L, new BookTitle("test2", "test2", LocalDate.now()), BookStatus.LOST),
                new BookCopyResponse(3L, new BookTitle("test2", "test2", LocalDate.now()), BookStatus.DESTROYED),
                new BookCopyResponse(4L, new BookTitle("test2", "test2", LocalDate.now()), BookStatus.RENTED),
                new BookCopyResponse(5L, new BookTitle("test2", "test2", LocalDate.now()), BookStatus.AVAILABLE),
                new BookCopyResponse(6L, new BookTitle("test2", "test2", LocalDate.now()), BookStatus.AVAILABLE),
                new BookCopyResponse(7L, new BookTitle("test2", "test2", LocalDate.now()), BookStatus.AVAILABLE),
                new BookCopyResponse(8L, new BookTitle("test2", "test2", LocalDate.now()), BookStatus.AVAILABLE),
                new BookCopyResponse(9L, new BookTitle("test2", "test2", LocalDate.now()), BookStatus.AVAILABLE)));

        // When
        Long amountOfBookCopiesFoundByStatusAndTitle = bookCopyService.countBookCopyByTitle(BookStatus.AVAILABLE, "test");

        //Then
        assertThat(amountOfBookCopiesFoundByStatusAndTitle).isEqualTo(1L);
    }

    @Test
    void shouldCreateBookCopy() {
        // Given
        BookTitle bookTitle = new BookTitle("test", "test", LocalDate.now());
        when(bookTitleRepository.findById(1L)).thenReturn(Optional.of(bookTitle));
        when(bookCopyRepository.save(any(BookCopy.class))).thenReturn(new BookCopy());
        when(bookCopyMapper.mapToBookCopyResponse(any(BookCopy.class))).thenReturn(new BookCopyResponse(1L, bookTitle, BookStatus.AVAILABLE));

        // When
        BookCopyResponse bookCopyResponse = bookCopyService.createBookCopy(new CreateBookCopyRequest(1L));

        // Then
        assertThat(bookCopyResponse).isNotNull();
    }
}