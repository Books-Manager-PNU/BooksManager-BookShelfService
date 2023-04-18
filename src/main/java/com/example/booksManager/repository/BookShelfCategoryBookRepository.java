package com.example.booksManager.repository;

import com.example.booksManager.entity.BookShelfCategoryBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookShelfCategoryBookRepository extends JpaRepository<BookShelfCategoryBook, Long> {
}
