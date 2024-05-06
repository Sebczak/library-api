package com.company.controllers;

import com.company.dto.requests.CreateNewReaderRequest;
import com.company.dto.responses.ReaderResponse;
import com.company.services.ReaderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/v1/reader")
@CrossOrigin("*")
public class ReaderController {

    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
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
