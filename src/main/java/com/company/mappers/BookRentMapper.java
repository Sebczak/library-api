package com.company.mappers;

import com.company.dto.BookRentDto;
import com.company.entities.BookRent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRentMapper {

    public BookRentDto mapToBookRentDto(BookRent bookRent) {
        return new BookRentDto(
                bookRent.getBookCopy().getBookCopyId(),
                bookRent.getReader().getReaderId(),
                bookRent.getRentalDate(),
                bookRent.getReturnDate()
        );
    }

    public List<BookRentDto> mapToBookRentDtoList(List<BookRent> bookRents) {
        return bookRents.stream()
                .map(this::mapToBookRentDto)
                .toList();
    }
}
