package com.example.booksManager.repository;

import com.example.booksManager.entity.BookShelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookShelfRepository extends JpaRepository<BookShelf, Long> {
}
