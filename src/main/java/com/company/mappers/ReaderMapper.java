package com.company.mappers;

import com.company.dto.ReaderDto;
import com.company.entities.Reader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderMapper {

    public ReaderDto mapToReaderDto(Reader reader) {
        return new ReaderDto(
                reader.getFirstName(),
                reader.getLastName(),
                reader.getAccountCreationDate()
        );
    }

    public List<ReaderDto> mapToReaderDtoList(List<Reader> readers) {
        return readers.stream()
                .map(this::mapToReaderDto)
                .toList();
    }

    public Reader mapToReader(ReaderDto readerDto) {
        return new Reader(
                readerDto.firstname(),
                readerDto.lastname()
        );
    }
}
