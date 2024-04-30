package com.company.services;

import com.company.dto.requests.CreateNewReaderRequest;
import com.company.dto.responses.ReaderResponse;
import com.company.entities.Reader;
import com.company.mappers.ReaderMapper;
import com.company.repositories.ReaderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ReaderServiceTest {

    @InjectMocks
    private ReaderService readerService;
    @Mock
    private ReaderRepository readerRepository;
    @Mock
    private ReaderMapper readerMapper;
    private CreateNewReaderRequest createNewReaderRequest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        readerService = new ReaderService(readerRepository, readerMapper);
        createNewReaderRequest = new CreateNewReaderRequest("test", "test");
    }

    @Test
    void shouldCreateReader() {
        //Given
        when(readerMapper.mapToReaderResponse(any(Reader.class))).thenReturn(new ReaderResponse(999L, createNewReaderRequest.firstName(), createNewReaderRequest.lastName(), LocalDate.now()));
        when(readerRepository.save(any(Reader.class))).thenReturn(new Reader());

        //When
        ReaderResponse readerResponse = readerService.createReader(createNewReaderRequest);

        //Then
        assertThat(readerResponse.firstname()).isEqualTo("test");
    }

    @Test
    void shouldGetAllReaders() {
        // Given
        List<Reader> readers = List.of(new Reader());
        when(readerRepository.findAll()).thenReturn(readers);
        when(readerMapper.mapToReaderResponseList(any(List.class))).thenReturn(List.of(new ReaderResponse(999L, createNewReaderRequest.firstName(), createNewReaderRequest.lastName(), LocalDate.now())));

        // When
        List<ReaderResponse> readerResponses = readerService.getAllReaders();

        // Then
        assertThat(readerResponses.size()).isEqualTo(1);
    }
}