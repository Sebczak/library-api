package com.company.mappers;

import com.company.dto.requests.CreateNewReaderRequest;
import com.company.dto.responses.ReaderResponse;
import com.company.entities.Reader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderMapper {

    public ReaderResponse mapToReaderResponse(Reader reader) {
        return new ReaderResponse(
                reader.getReaderId(),
                reader.getFirstName(),
                reader.getLastName(),
                reader.getAccountCreationDate()
        );
    }

    public List<ReaderResponse> mapToReaderResponseList(List<Reader> readers) {
        return readers.stream()
                .map(this::mapToReaderResponse)
                .toList();
    }

    public Reader mapToReader(ReaderResponse readerResponse) {
        return new Reader(
                readerResponse.readerId(),
                readerResponse.firstname(),
                readerResponse.lastname()
        );
    }
}
