package com.example.booksManager.service.impl;

import com.example.booksManager.dto.bookShelfCategoryBook.BookShelfCategoryBookRequestDto;
import com.example.booksManager.dto.bookShelfCategoryBook.BookShelfCategoryBookResponseDto;
import com.example.booksManager.entity.BookShelfCategoryBook;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.BookShelfCategoryBookMapper;
import com.example.booksManager.repository.BookShelfCategoryBookRepository;
import com.example.booksManager.service.BookShelfCategoryBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookShelfCategoryBookServiceImpl implements BookShelfCategoryBookService {
    private final BookShelfCategoryBookRepository bookShelfCategoryBookRepository;
    private final BookShelfCategoryBookMapper bookShelfCategoryBookMapper;

    @Override
    public BookShelfCategoryBookResponseDto save(BookShelfCategoryBookRequestDto categoryBook, Long userId) {
        BookShelfCategoryBook newCategoryBook = bookShelfCategoryBookMapper.toEntity(categoryBook);
        return bookShelfCategoryBookMapper.toResponseDto(bookShelfCategoryBookRepository.save(newCategoryBook));
    }

    @Override
    public List<BookShelfCategoryBookResponseDto> findAll() {
        return bookShelfCategoryBookRepository.findAll()
                .stream()
                .map(bookShelfCategoryBookMapper::toResponseDto)
                .toList();
    }

    @Override
    public BookShelfCategoryBookResponseDto findById(Long id) {
        BookShelfCategoryBook newCategoryBook = getExistingBookById(id);
        return bookShelfCategoryBookMapper.toResponseDto(bookShelfCategoryBookRepository.save(newCategoryBook));
    }

    @Override
    public BookShelfCategoryBookResponseDto update(Long id, BookShelfCategoryBookRequestDto categoryBook, Long userId) {
        BookShelfCategoryBook newCategoryBook = getExistingBookById(id);
        bookShelfCategoryBookMapper.updateEntity(categoryBook, newCategoryBook);
        bookShelfCategoryBookRepository.save(newCategoryBook);
        return bookShelfCategoryBookMapper.toResponseDto(newCategoryBook);
    }

    @Override
    public void remove(Long id) {
        BookShelfCategoryBook newCategory = getExistingBookById(id);
        bookShelfCategoryBookRepository.delete(newCategory);
    }

    private BookShelfCategoryBook getExistingBookById(Long id) {
        return bookShelfCategoryBookRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "BookShelfCategoryBook not found"));
    }
}
