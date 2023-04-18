package com.example.booksManager.service;

import com.example.booksManager.dto.bookShelfBook.BookShelfBookRequestDto;
import com.example.booksManager.dto.bookShelfBook.BookShelfBookResponseDto;

import java.util.List;

public interface BookShelfBookService {
    BookShelfBookResponseDto save(BookShelfBookRequestDto book);
    List<BookShelfBookResponseDto> findAll();
    BookShelfBookResponseDto findById(long id);
    BookShelfBookResponseDto update(long id, BookShelfBookRequestDto book);
    void remove(long id);
}
