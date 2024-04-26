package com.company.mappers;

import com.company.dto.responses.BookTitleResponse;
import com.company.entities.BookTitle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTitleMapper {

    public BookTitleResponse mapToBookTitleResponse(BookTitle bookTitle) {
        return new BookTitleResponse(
                bookTitle.getTitle(),
                bookTitle.getAuthor(),
                bookTitle.getPublishDate()
        );
    }

    public List<BookTitleResponse> mapToBookTitleDtoList(List<BookTitle> bookTitles) {
        return bookTitles.stream()
                .map(this::mapToBookTitleResponse)
                .toList();
    }

    public BookTitle mapToBookTitle(BookTitleResponse bookTitleResponse) {
        return new BookTitle(
                bookTitleResponse.title(),
                bookTitleResponse.author(),
                bookTitleResponse.publishDate()
        );
    }
}
