package com.example.booksManager.service;

import com.example.booksManager.dto.bookShelf.BookShelfRequestDto;
import com.example.booksManager.dto.bookShelf.BookShelfResponseDto;

import java.util.List;

public interface BookShelfService {
    BookShelfResponseDto save(BookShelfRequestDto bookShelf);
    List<BookShelfResponseDto> findAll();
    BookShelfResponseDto findById(long id);
    BookShelfResponseDto update(long id, BookShelfRequestDto bookShelf);
    void remove(long id);
}
