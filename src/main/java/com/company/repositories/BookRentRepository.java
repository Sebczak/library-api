package com.company.repositories;

import com.company.entities.BookRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRentRepository extends JpaRepository<BookRent, Long> {
}
