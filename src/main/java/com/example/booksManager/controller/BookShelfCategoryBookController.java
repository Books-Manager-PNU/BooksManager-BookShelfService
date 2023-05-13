package com.example.booksManager.controller;

import com.example.booksManager.dto.bookShelfCategoryBook.BookShelfCategoryBookRequestDto;
import com.example.booksManager.dto.bookShelfCategoryBook.BookShelfCategoryBookResponseDto;
import com.example.booksManager.service.BookShelfCategoryBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelf-category-books")
public class BookShelfCategoryBookController {
    private final BookShelfCategoryBookService bookShelfCategoryBookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookShelfCategoryBookResponseDto addBookShelf(
            @RequestBody BookShelfCategoryBookRequestDto categoryBookDto,
            @RequestParam("user") Long userId
    ) {
        return bookShelfCategoryBookService.save(categoryBookDto, userId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookShelfCategoryBookResponseDto> findAll() {
        return bookShelfCategoryBookService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookShelfCategoryBookResponseDto findById(@PathVariable Long id) {
        return bookShelfCategoryBookService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookShelfCategoryBookResponseDto updateBookShelfById(
            @PathVariable Long id,
            @RequestBody BookShelfCategoryBookRequestDto categoryBookDto,
            @RequestParam("user") Long userId
    ) {
        return bookShelfCategoryBookService.update(id, categoryBookDto, userId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookShelfById(@PathVariable Long id) {
        bookShelfCategoryBookService.remove(id);
    }

}
