package com.company.services;

import com.company.dto.requests.CreateNewReaderRequest;
import com.company.dto.responses.ReaderResponse;
import com.company.entities.Reader;
import com.company.mappers.ReaderMapper;
import com.company.repositories.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final ReaderMapper readerMapper;
    public ReaderService(ReaderRepository readerRepository, ReaderMapper readerMapper) {
        this.readerRepository = readerRepository;
        this.readerMapper = readerMapper;
    }

    public ReaderResponse createReader(CreateNewReaderRequest createNewReaderRequest) {

        Reader reader = new Reader(createNewReaderRequest.firstName(), createNewReaderRequest.lastName());
        readerRepository.save(reader);

        return readerMapper.mapToReaderResponse(reader);
    }

    public List<ReaderResponse> getAllReaders() {
        List<Reader> readers = readerRepository.findAll();
        return readerMapper.mapToReaderResponseList(readers);
    }
}
