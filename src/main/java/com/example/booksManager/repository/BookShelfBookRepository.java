package com.example.booksManager.repository;

import com.example.booksManager.entity.BookShelfBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookShelfBookRepository extends JpaRepository<BookShelfBook, Long> {
}
