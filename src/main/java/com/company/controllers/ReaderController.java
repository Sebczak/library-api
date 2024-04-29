package com.company.controllers;

import com.company.dto.requests.CreateNewReaderRequest;
import com.company.dto.responses.ReaderResponse;
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
    public List<ReaderResponse> getAllReaders() {
        return readerService.getAllReaders();
    }

    @PostMapping
    public ReaderResponse createReader(@RequestBody CreateNewReaderRequest createNewReaderRequest) {
        return readerService.createReader(createNewReaderRequest);
    }
}
