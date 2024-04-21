package com.company.repositories;

import com.company.entities.BookTitle;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BookTitleRepository extends JpaRepository<BookTitle, Long> {
}
