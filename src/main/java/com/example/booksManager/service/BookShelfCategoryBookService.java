package com.example.booksManager.service;

import com.example.booksManager.dto.bookShelfCategoryBook.BookShelfCategoryBookRequestDto;
import com.example.booksManager.dto.bookShelfCategoryBook.BookShelfCategoryBookResponseDto;

import java.util.List;

public interface BookShelfCategoryBookService {
    BookShelfCategoryBookResponseDto save(BookShelfCategoryBookRequestDto book);
    List<BookShelfCategoryBookResponseDto> findAll();
    BookShelfCategoryBookResponseDto findById(long id);
    BookShelfCategoryBookResponseDto update(long id, BookShelfCategoryBookRequestDto book);
    void remove(long id);
}
