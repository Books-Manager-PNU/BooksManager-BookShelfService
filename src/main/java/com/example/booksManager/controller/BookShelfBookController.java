package com.example.booksManager.controller;

import com.example.booksManager.dto.bookShelfBook.BookShelfBookRequestDto;
import com.example.booksManager.dto.bookShelfBook.BookShelfBookResponseDto;
import com.example.booksManager.service.BookShelfBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelf-books")
public class BookShelfBookController {
    private final BookShelfBookService bookShelfBookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookShelfBookResponseDto addBookShelfBook(
            @RequestBody BookShelfBookRequestDto bookShelfBookDto,
            @RequestParam("user") Long userId
    ) {
        return bookShelfBookService.save(bookShelfBookDto, userId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookShelfBookResponseDto> findAll() {
        return bookShelfBookService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookShelfBookResponseDto findById(@PathVariable Long id) {
        return bookShelfBookService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookShelfBookResponseDto updateBookShelfById(
            @PathVariable Long id,
            @RequestBody BookShelfBookRequestDto bookShelfBookDto,
            @RequestParam("user") Long userId
    ) {
        return bookShelfBookService.update(id, bookShelfBookDto, userId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookShelfById(@PathVariable Long id) {
        bookShelfBookService.remove(id);
    }

}
