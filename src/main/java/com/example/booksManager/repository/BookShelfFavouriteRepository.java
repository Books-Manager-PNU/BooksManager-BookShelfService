package com.example.booksManager.repository;

import com.example.booksManager.entity.BookShelfFavourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookShelfFavouriteRepository extends JpaRepository<BookShelfFavourite, Long> {
}
