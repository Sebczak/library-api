package com.company.controllers;

import com.company.dto.ReaderDto;
import com.company.entities.Reader;
import com.company.mappers.ReaderMapper;
import com.company.repositories.ReaderRepository;
import com.company.services.ReaderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/v1/reader")
public class ReaderController {

    private final ReaderRepository readerRepository;
    private final ReaderMapper readerMapper;
    private final ReaderService readerService;

    public ReaderController(ReaderRepository readerRepository, ReaderMapper readerMapper, ReaderService readerService) {
        this.readerRepository = readerRepository;
        this.readerMapper = readerMapper;
        this.readerService = readerService;
    }

    @GetMapping
    public List<ReaderDto> getAllReaders() {
        List<Reader> readers = readerRepository.findAll();
        return readerMapper.mapToReaderDtoList(readers);
    }

    @PostMapping
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        readerService.createReader(readerDto);
        return readerDto;
    }
}
