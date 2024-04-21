package com.company.repositories;

import com.company.entities.Reader;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
