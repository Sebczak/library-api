package com.company.services;

import com.company.dto.responses.ReaderResponse;
import com.company.entities.Reader;
import com.company.mappers.ReaderMapper;
import com.company.repositories.ReaderRepository;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final ReaderMapper readerMapper;
    public ReaderService(ReaderRepository readerRepository, ReaderMapper readerMapper) {
        this.readerRepository = readerRepository;
        this.readerMapper = readerMapper;
    }

    public void createReader(ReaderResponse readerResponse) {

        Reader reader = readerMapper.mapToReader(readerResponse);
        readerRepository.save(reader);

    }
}
