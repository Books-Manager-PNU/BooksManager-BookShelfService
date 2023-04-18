package com.example.booksManager.service;

import com.example.booksManager.dto.bookshelfFavourite.BookShelfFavouriteRequestDto;
import com.example.booksManager.dto.bookshelfFavourite.BookShelfFavouriteResponseDto;

import java.util.List;

public interface BookShelfFavouriteService {
    BookShelfFavouriteResponseDto save(BookShelfFavouriteRequestDto favourite);
    List<BookShelfFavouriteResponseDto> findAll();
    BookShelfFavouriteResponseDto findById(long id);
    BookShelfFavouriteResponseDto update(long id, BookShelfFavouriteRequestDto favourite);
    void remove(long id);
}
