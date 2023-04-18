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
    public BookShelfCategoryBookResponseDto save(BookShelfCategoryBookRequestDto categoryBook) {
        BookShelfCategoryBook newCategoryBook = bookShelfCategoryBookMapper.toEntity(categoryBook);
        return bookShelfCategoryBookMapper.toBookShelfCategoryBookResponseDto(bookShelfCategoryBookRepository.save(newCategoryBook));
    }

    @Override
    public List<BookShelfCategoryBookResponseDto> findAll() {
        return bookShelfCategoryBookRepository.findAll()
                .stream()
                .map(bookShelfCategoryBookMapper::toBookShelfCategoryBookResponseDto)
                .toList();
    }

    @Override
    public BookShelfCategoryBookResponseDto findById(long id) {
        BookShelfCategoryBook newCategoryBook = getExistingBookById(id);
        return bookShelfCategoryBookMapper.toBookShelfCategoryBookResponseDto(bookShelfCategoryBookRepository.save(newCategoryBook));
    }

    @Override
    public BookShelfCategoryBookResponseDto update(long id, BookShelfCategoryBookRequestDto categoryBook) {
        BookShelfCategoryBook newCategoryBook = getExistingBookById(id);
        bookShelfCategoryBookMapper.updateEntity(categoryBook, newCategoryBook);
        bookShelfCategoryBookRepository.save(newCategoryBook);
        return bookShelfCategoryBookMapper.toBookShelfCategoryBookResponseDto(newCategoryBook);
    }

    @Override
    public void remove(long id) {
        BookShelfCategoryBook newCategory = getExistingBookById(id);
        bookShelfCategoryBookRepository.delete(newCategory);
    }

    private BookShelfCategoryBook getExistingBookById(long id) {
        return bookShelfCategoryBookRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "BookShelfCategoryBook not found"));
    }
}
