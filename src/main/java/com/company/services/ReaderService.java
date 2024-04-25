package com.company.services;

import com.company.dto.ReaderDto;
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

    public void createReader(ReaderDto readerDto) {

        Reader reader = readerMapper.mapToReader(readerDto);
        readerRepository.save(reader);

    }
}
