package com.company.mappers;

import com.company.dto.responses.BookCopyResponse;
import com.company.entities.BookCopy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyMapper {

    public BookCopyResponse mapToBookCopyResponse(BookCopy bookCopy) {
        return new BookCopyResponse(
                bookCopy.getBookCopyId(),
                bookCopy.getBookTitle(),
                bookCopy.getStatus()
        );
    }

    public List<BookCopyResponse> mapToBookCopyDtoList(List<BookCopy> bookCopyList) {
        return bookCopyList.stream()
                .map(this::mapToBookCopyResponse)
                .toList();
    }

    public BookCopy mapToBookCopy(BookCopyResponse bookCopyResponse) {
        return new BookCopy(
                bookCopyResponse.bookCopyId(),
                bookCopyResponse.bookTitle(),
                bookCopyResponse.status()
        );
    }
}
