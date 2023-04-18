package com.example.booksManager.service.impl;

import com.example.booksManager.dto.bookShelf.BookShelfRequestDto;
import com.example.booksManager.dto.bookShelf.BookShelfResponseDto;
import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryRequestDto;
import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryResponseDto;
import com.example.booksManager.entity.BookShelf;
import com.example.booksManager.entity.BookShelfCategory;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.BookShelfCategoryMapper;
import com.example.booksManager.repository.BookShelfCategoryRepository;
import com.example.booksManager.service.BookShelfCategoryService;
import com.example.booksManager.service.BookShelfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookShelfCategoryServiceImpl implements BookShelfCategoryService {
    private final BookShelfCategoryRepository bookShelfCategoryRepository;
    private final BookShelfCategoryMapper bookShelfCategoryMapper;

    @Override
    public BookShelfCategoryResponseDto save(BookShelfCategoryRequestDto category) {
        BookShelfCategory newCategory = bookShelfCategoryMapper.toEntity(category);
        return bookShelfCategoryMapper.toBookShelfCategoryResponseDto(bookShelfCategoryRepository.save(newCategory));
    }

    @Override
    public List<BookShelfCategoryResponseDto> findAll() {
        return bookShelfCategoryRepository.findAll()
                .stream()
                .map(bookShelfCategoryMapper::toBookShelfCategoryResponseDto)
                .toList();
    }

    @Override
    public BookShelfCategoryResponseDto findById(long id) {
        BookShelfCategory newCategory = getExistingBookById(id);
        return bookShelfCategoryMapper.toBookShelfCategoryResponseDto(bookShelfCategoryRepository.save(newCategory));
    }

    @Override
    public BookShelfCategoryResponseDto update(long id, BookShelfCategoryRequestDto category) {
        BookShelfCategory newCategory = getExistingBookById(id);
        bookShelfCategoryMapper.updateEntity(category, newCategory);
        bookShelfCategoryRepository.save(newCategory);
        return bookShelfCategoryMapper.toBookShelfCategoryResponseDto(newCategory);
    }

    @Override
    public void remove(long id) {
        BookShelfCategory newCategory = getExistingBookById(id);
        bookShelfCategoryRepository.delete(newCategory);
    }

    private BookShelfCategory getExistingBookById(long id) {
        return bookShelfCategoryRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "BookShelfCategory not found"));
    }
}
