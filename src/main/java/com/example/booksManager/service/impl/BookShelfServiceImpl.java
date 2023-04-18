package com.example.booksManager.service.impl;

import com.example.booksManager.dto.bookShelf.BookShelfRequestDto;
import com.example.booksManager.dto.bookShelf.BookShelfResponseDto;
import com.example.booksManager.entity.BookShelf;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.BookShelfMapper;
import com.example.booksManager.repository.BookShelfRepository;
import com.example.booksManager.service.BookShelfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookShelfServiceImpl implements BookShelfService {
    private final BookShelfRepository bookShelfRepository;
    private final BookShelfMapper bookShelfMapper;

    @Override
    public BookShelfResponseDto save(BookShelfRequestDto bookShelfDto) {
        BookShelf newBookShelf = bookShelfMapper.toEntity(bookShelfDto);
        return bookShelfMapper.toBookShelfResponseDto(bookShelfRepository.save(newBookShelf));
    }

    @Override
    public List<BookShelfResponseDto> findAll() {
        return bookShelfRepository.findAll()
                .stream()
                .map(bookShelfMapper::toBookShelfResponseDto)
                .toList();
    }

    @Override
    public BookShelfResponseDto findById(long id) {
        BookShelf bookShelf = getExistingBookById(id);
        return bookShelfMapper.toBookShelfResponseDto(bookShelfRepository.save(bookShelf));
    }

    @Override
    public BookShelfResponseDto update(long id, BookShelfRequestDto bookShelfDto) {
        BookShelf bookShelf = getExistingBookById(id);
        bookShelfMapper.updateEntity(bookShelfDto, bookShelf);
        bookShelfRepository.save(bookShelf);
        return bookShelfMapper.toBookShelfResponseDto(bookShelf);
    }

    @Override
    public void remove(long id) {
        BookShelf bookShelf = getExistingBookById(id);
        bookShelfRepository.delete(bookShelf);
    }

    private BookShelf getExistingBookById(long id) {
        return bookShelfRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "BookShelf not found"));
    }
}
