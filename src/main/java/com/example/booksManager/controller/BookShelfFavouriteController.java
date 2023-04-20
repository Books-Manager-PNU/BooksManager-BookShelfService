package com.example.booksManager.controller;

import com.example.booksManager.dto.bookShelf.BookShelfRequestDto;
import com.example.booksManager.dto.bookShelf.BookShelfResponseDto;
import com.example.booksManager.dto.bookshelfFavourite.BookShelfFavouriteRequestDto;
import com.example.booksManager.dto.bookshelfFavourite.BookShelfFavouriteResponseDto;
import com.example.booksManager.service.BookShelfFavouriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelf-favourites")
public class BookShelfFavouriteController {
    private final BookShelfFavouriteService bookShelfFavouriteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookShelfFavouriteResponseDto addBookShelf(@RequestBody BookShelfFavouriteRequestDto favouriteDto) {
        return bookShelfFavouriteService.save(favouriteDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookShelfFavouriteResponseDto> findAll() {
        return bookShelfFavouriteService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookShelfFavouriteResponseDto findById(@PathVariable long id) {
        return bookShelfFavouriteService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookShelfFavouriteResponseDto updateBookShelfById(@PathVariable long id,
                                                             @RequestBody BookShelfFavouriteRequestDto favouriteDto) {
        return bookShelfFavouriteService.update(id, favouriteDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookShelfById(@PathVariable long id) {
        bookShelfFavouriteService.remove(id);
    }

}
