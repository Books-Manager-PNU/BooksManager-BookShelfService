package com.example.booksManager.controller;

import com.example.booksManager.dto.bookShelfCategoryBook.BookShelfCategoryBookRequestDto;
import com.example.booksManager.dto.bookShelfCategoryBook.BookShelfCategoryBookResponseDto;
import com.example.booksManager.service.BookShelfCategoryBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelf-category-books")
public class BookShelfCategoryBookController {
    private final BookShelfCategoryBookService bookShelfCategoryBookService;

    @PostMapping
    public ResponseEntity<BookShelfCategoryBookResponseDto> add(
            @RequestBody BookShelfCategoryBookRequestDto requestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookShelfCategoryBookService.save(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<BookShelfCategoryBookResponseDto>> findAll() {
        return ResponseEntity.ok(bookShelfCategoryBookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookShelfCategoryBookResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookShelfCategoryBookService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookShelfCategoryBookResponseDto> update(
            @PathVariable Long id,
            @RequestBody BookShelfCategoryBookRequestDto requestDto
    ) {
        return ResponseEntity.accepted()
                .body(bookShelfCategoryBookService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookShelfCategoryBookService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
