package com.example.booksManager.controller;

import com.example.booksManager.dto.bookShelfBook.BookShelfBookRequestDto;
import com.example.booksManager.dto.bookShelfBook.BookShelfBookResponseDto;
import com.example.booksManager.service.BookShelfBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelf-books")
public class BookShelfBookController {
    private final BookShelfBookService bookShelfBookService;

    @PostMapping
    public ResponseEntity<BookShelfBookResponseDto> add(
            @RequestBody BookShelfBookRequestDto requestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookShelfBookService.save(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<BookShelfBookResponseDto>> findAll() {
        return ResponseEntity.ok(bookShelfBookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookShelfBookResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookShelfBookService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookShelfBookResponseDto> update(
            @PathVariable Long id,
            @RequestBody BookShelfBookRequestDto requestDto
    ) {
        return ResponseEntity.accepted()
                .body(bookShelfBookService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookShelfBookService.remove(id);
        return ResponseEntity.noContent().build();
    }

}
