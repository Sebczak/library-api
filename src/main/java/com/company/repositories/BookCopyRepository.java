package com.company.repositories;

import com.company.entities.BookCopy;
import com.company.entities.BookStatus;
import com.company.entities.BookTitle;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {

    @Query
    List<BookCopy> findByTitleAndStatus(String title, BookStatus status);
}
