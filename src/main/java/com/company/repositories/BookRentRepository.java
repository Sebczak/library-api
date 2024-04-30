package com.company.repositories;

import com.company.entities.BookRent;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BookRentRepository extends JpaRepository<BookRent, Long> {
}
