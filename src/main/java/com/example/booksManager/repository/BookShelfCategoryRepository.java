package com.example.booksManager.repository;

import com.example.booksManager.entity.BookShelfCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookShelfCategoryRepository extends JpaRepository<BookShelfCategory, Long> {
}
