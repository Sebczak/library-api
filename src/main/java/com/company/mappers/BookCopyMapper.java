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

    public List<BookCopyResponse> mapToBookCopyResponseList(List<BookCopy> bookCopies) {
        return bookCopies.stream()
                .map(this::mapToBookCopyResponse)
                .toList();
    }
}
