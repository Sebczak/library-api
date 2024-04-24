package com.company.mappers;

import com.company.dtos.BookCopyDto;
import com.company.entities.BookCopy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyMapper {

    public BookCopyDto mapToBookCopyDto(BookCopy bookCopy) {
        return new BookCopyDto(
                bookCopy.getBookCopyId(),
                bookCopy.getBookTitle(),
                bookCopy.getStatus()
        );
    }

    public List<BookCopyDto> mapToBookCopyDtoList(List<BookCopy> bookCopyList) {
        return bookCopyList.stream()
                .map(this::mapToBookCopyDto)
                .toList();
    }

    public BookCopy mapToBookCopy(BookCopyDto bookCopyDto) {
        return new BookCopy(
                bookCopyDto.bookCopyId(),
                bookCopyDto.bookTitle(),
                bookCopyDto.status()
        );
    }
}
