package com.example.booksManager.controller;

import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryRequestDto;
import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryResponseDto;
import com.example.booksManager.service.BookShelfCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelf-categories")
public class BookShelfCategoryController {
    private final BookShelfCategoryService bookShelfCategoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookShelfCategoryResponseDto addBookShelf(
            @RequestBody BookShelfCategoryRequestDto bookShelfCategoryDto,
            @RequestParam("user") Long userId
    ) {
        return bookShelfCategoryService.save(bookShelfCategoryDto, userId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookShelfCategoryResponseDto> findAll() {
        return bookShelfCategoryService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookShelfCategoryResponseDto findById(@PathVariable Long id) {
        return bookShelfCategoryService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookShelfCategoryResponseDto updateBookShelfById(
            @PathVariable Long id,
            @RequestBody BookShelfCategoryRequestDto bookShelfCategoryDto,
            @RequestParam("user") Long userId
    ) {
        return bookShelfCategoryService.update(id, bookShelfCategoryDto, userId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookShelfById(@PathVariable Long id) {
        bookShelfCategoryService.remove(id);
    }

}
