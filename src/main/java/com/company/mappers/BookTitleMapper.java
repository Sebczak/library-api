package com.company.mappers;

import com.company.dtos.BookTitleDto;
import com.company.entities.BookTitle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTitleMapper {

    public BookTitleDto mapToBookTitleDto(BookTitle bookTitle) {
        return new BookTitleDto(
                bookTitle.getTitle(),
                bookTitle.getAuthor(),
                bookTitle.getPublishDate()
        );
    }

    public List<BookTitleDto> mapToBookTitleDtoList(List<BookTitle> bookTitles) {
        return bookTitles.stream()
                .map(this::mapToBookTitleDto)
                .toList();
    }

    public BookTitle mapToBookTitle(BookTitleDto bookTitleDto) {
        return new BookTitle(
                bookTitleDto.title(),
                bookTitleDto.author(),
                bookTitleDto.publishDate()
        );
    }
}
