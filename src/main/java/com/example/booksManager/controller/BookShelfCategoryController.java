package com.example.booksManager.controller;

import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryRequestDto;
import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryResponseDto;
import com.example.booksManager.service.BookShelfCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelf-categories")
public class BookShelfCategoryController {
    private final BookShelfCategoryService bookShelfCategoryService;

    @PostMapping
    public ResponseEntity<BookShelfCategoryResponseDto> add(
            @RequestBody BookShelfCategoryRequestDto requestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookShelfCategoryService.save(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<BookShelfCategoryResponseDto>> findAll() {
        return ResponseEntity.ok(bookShelfCategoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookShelfCategoryResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookShelfCategoryService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookShelfCategoryResponseDto> update(
            @PathVariable Long id,
            @RequestBody BookShelfCategoryRequestDto requestDto
    ) {
        return ResponseEntity.accepted()
                .body(bookShelfCategoryService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookShelfCategoryService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
