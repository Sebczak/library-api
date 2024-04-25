package com.company.mappers;

import com.company.dto.responses.ReaderResponse;
import com.company.entities.Reader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderMapper {

    public ReaderResponse mapToReaderDto(Reader reader) {
        return new ReaderResponse(
                reader.getFirstName(),
                reader.getLastName(),
                reader.getAccountCreationDate()
        );
    }

    public List<ReaderResponse> mapToReaderDtoList(List<Reader> readers) {
        return readers.stream()
                .map(this::mapToReaderDto)
                .toList();
    }

    public Reader mapToReader(ReaderResponse readerResponse) {
        return new Reader(
                readerResponse.firstname(),
                readerResponse.lastname()
        );
    }
}
