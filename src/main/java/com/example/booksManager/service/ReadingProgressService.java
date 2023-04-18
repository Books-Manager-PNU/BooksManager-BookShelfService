package com.example.booksManager.service;

import com.example.booksManager.dto.bookShelf.BookShelfRequestDto;
import com.example.booksManager.dto.bookShelf.BookShelfResponseDto;
import com.example.booksManager.dto.readingProgress.ReadingProgressRequestDto;
import com.example.booksManager.dto.readingProgress.ReadingProgressResponseDto;

import java.util.List;

public interface ReadingProgressService {
    ReadingProgressResponseDto save(ReadingProgressRequestDto readingProgress);
    List<ReadingProgressResponseDto> findAll();
    ReadingProgressResponseDto findById(long id);
    ReadingProgressResponseDto update(long id, ReadingProgressRequestDto readingProgress);
    void remove(long id);
}
