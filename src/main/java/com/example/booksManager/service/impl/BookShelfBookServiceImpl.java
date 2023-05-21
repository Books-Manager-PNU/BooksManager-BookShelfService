package com.example.booksManager.service.impl;

import com.example.booksManager.dto.bookShelfBook.BookShelfBookRequestDto;
import com.example.booksManager.dto.bookShelfBook.BookShelfBookResponseDto;
import com.example.booksManager.entity.BookShelfBook;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.BookShelfBookMapper;
import com.example.booksManager.repository.BookShelfBookRepository;
import com.example.booksManager.service.BookShelfBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookShelfBookServiceImpl implements BookShelfBookService {
    private final BookShelfBookRepository bookShelfBookRepository;
    private final BookShelfBookMapper bookShelfBookMapper;

    @Override
    public BookShelfBookResponseDto save(BookShelfBookRequestDto book) {
        BookShelfBook newBookShelfBook = bookShelfBookMapper.toEntity(book);
        return bookShelfBookMapper.toResponseDto(bookShelfBookRepository.save(newBookShelfBook));
    }

    @Override
    public List<BookShelfBookResponseDto> findAll() {
        return bookShelfBookRepository.findAll()
                .stream()
                .map(bookShelfBookMapper::toResponseDto)
                .toList();
    }

    @Override
    public BookShelfBookResponseDto findById(Long id) {
        BookShelfBook bookShelfBook = getExistingBookById(id);
        return bookShelfBookMapper.toResponseDto(bookShelfBookRepository.save(bookShelfBook));
    }

    @Override
    public BookShelfBookResponseDto update(Long id, BookShelfBookRequestDto bookDto) {
        BookShelfBook bookShelfBook = getExistingBookById(id);
        bookShelfBookMapper.updateEntity(bookDto, bookShelfBook);
        bookShelfBookRepository.save(bookShelfBook);
        return bookShelfBookMapper.toResponseDto(bookShelfBook);
    }

    @Override
    public void remove(Long id) {
        BookShelfBook bookShelfBook = getExistingBookById(id);
        bookShelfBookRepository.delete(bookShelfBook);
    }

    private BookShelfBook getExistingBookById(Long id) {
        return bookShelfBookRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "BookShelfBook not found"));
    }
}
