package com.company.mappers;

import com.company.dto.responses.BookRentResponse;
import com.company.entities.BookRent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRentMapper {

    public BookRentResponse mapToBookRentResponse(BookRent bookRent) {
        return new BookRentResponse(
                bookRent.getBookCopy().getBookCopyId(),
                bookRent.getReader().getReaderId(),
                bookRent.getRentalDate(),
                bookRent.getReturnDate()
        );
    }

    public List<BookRentResponse> mapToBookRentDtoList(List<BookRent> bookRents) {
        return bookRents.stream()
                .map(this::mapToBookRentResponse)
                .toList();
    }
}
