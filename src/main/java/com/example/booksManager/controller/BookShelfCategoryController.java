package com.example.booksManager.controller;

import com.example.booksManager.dto.bookShelf.BookShelfRequestDto;
import com.example.booksManager.dto.bookShelf.BookShelfResponseDto;
import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryRequestDto;
import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryResponseDto;
import com.example.booksManager.entity.BookShelfCategory;
import com.example.booksManager.service.BookShelfCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelves/categories")
public class BookShelfCategoryController {
    private final BookShelfCategoryService bookShelfCategoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookShelfCategoryResponseDto addBookShelf(@RequestBody BookShelfCategoryRequestDto bookShelfCategoryDto) {
        return bookShelfCategoryService.save(bookShelfCategoryDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookShelfCategoryResponseDto> findAll() {
        return bookShelfCategoryService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookShelfCategoryResponseDto findById(@PathVariable long id) {
        return bookShelfCategoryService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookShelfCategoryResponseDto updateBookShelfById(@PathVariable long id,
                                                            @RequestBody BookShelfCategoryRequestDto bookShelfCategoryDto) {
        return bookShelfCategoryService.update(id, bookShelfCategoryDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookShelfById(@PathVariable long id) {
        bookShelfCategoryService.remove(id);
    }

}
