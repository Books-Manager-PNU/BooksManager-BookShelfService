package com.example.booksManager.service;

import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryRequestDto;
import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryResponseDto;

import java.util.List;

public interface BookShelfCategoryService {
    BookShelfCategoryResponseDto save(BookShelfCategoryRequestDto category);
    List<BookShelfCategoryResponseDto> findAll();
    BookShelfCategoryResponseDto findById(long id);
    BookShelfCategoryResponseDto update(long id, BookShelfCategoryRequestDto category);
    void remove(long id);
}
