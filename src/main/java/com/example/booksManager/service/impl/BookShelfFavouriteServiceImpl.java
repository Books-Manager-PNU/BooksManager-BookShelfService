package com.example.booksManager.service.impl;

import com.example.booksManager.dto.bookshelfFavourite.BookShelfFavouriteRequestDto;
import com.example.booksManager.dto.bookshelfFavourite.BookShelfFavouriteResponseDto;
import com.example.booksManager.entity.BookShelf;
import com.example.booksManager.entity.BookShelfFavourite;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.BookShelfFavouriteMapper;
import com.example.booksManager.repository.BookShelfFavouriteRepository;
import com.example.booksManager.service.BookShelfFavouriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookShelfFavouriteServiceImpl implements BookShelfFavouriteService {
    private final BookShelfFavouriteRepository bookShelfFavouriteRepository;
    private final BookShelfFavouriteMapper bookShelfFavouriteMapper;

    @Override
    public BookShelfFavouriteResponseDto save(BookShelfFavouriteRequestDto favourite) {
        BookShelfFavourite bookShelfFavourite = bookShelfFavouriteMapper.toEntity(favourite);
        return bookShelfFavouriteMapper.toBookShelfFavouriteResponseDto(bookShelfFavouriteRepository.save(bookShelfFavourite));
    }

    @Override
    public List<BookShelfFavouriteResponseDto> findAll() {
        return bookShelfFavouriteRepository.findAll()
                .stream()
                .map(bookShelfFavouriteMapper::toBookShelfFavouriteResponseDto)
                .toList();
    }

    @Override
    public BookShelfFavouriteResponseDto findById(long id) {
        BookShelfFavourite bookShelfFavourite = getExistingBookById(id);
        return bookShelfFavouriteMapper.toBookShelfFavouriteResponseDto(bookShelfFavouriteRepository.save(bookShelfFavourite));
    }

    @Override
    public BookShelfFavouriteResponseDto update(long id, BookShelfFavouriteRequestDto favourite) {
        BookShelfFavourite bookShelfFavourite = getExistingBookById(id);
        bookShelfFavouriteMapper.updateEntity(favourite, bookShelfFavourite);
        bookShelfFavouriteRepository.save(bookShelfFavourite);
        return bookShelfFavouriteMapper.toBookShelfFavouriteResponseDto(bookShelfFavourite);
    }

    @Override
    public void remove(long id) {
        BookShelfFavourite bookShelf = getExistingBookById(id);
        bookShelfFavouriteRepository.delete(bookShelf);
    }

    private BookShelfFavourite getExistingBookById(long id) {
        return bookShelfFavouriteRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "BookShelfFavourite not found"));
    }
}
