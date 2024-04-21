package com.company.repositories;

import com.company.entities.BookCopy;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {
}
