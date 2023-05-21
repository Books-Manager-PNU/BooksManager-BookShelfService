package com.example.booksManager.controller;

import com.example.booksManager.dto.bookShelf.BookShelfRequestDto;
import com.example.booksManager.dto.bookShelf.BookShelfResponseDto;
import com.example.booksManager.service.BookShelfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelves")
public class BookShelfController {
    private final BookShelfService bookShelfService;

    @PostMapping
    public ResponseEntity<BookShelfResponseDto> add(
            @RequestBody BookShelfRequestDto requestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookShelfService.save(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<BookShelfResponseDto>> findAll() {
        return ResponseEntity.ok(bookShelfService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookShelfResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookShelfService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookShelfResponseDto> update(
            @PathVariable Long id,
            @RequestBody BookShelfRequestDto requestDto
    ) {
        return ResponseEntity.accepted()
                .body(bookShelfService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookShelfService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
