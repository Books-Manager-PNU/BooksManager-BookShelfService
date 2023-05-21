package com.example.booksManager.controller;

import com.example.booksManager.dto.bookshelfFavourite.BookShelfFavouriteRequestDto;
import com.example.booksManager.dto.bookshelfFavourite.BookShelfFavouriteResponseDto;
import com.example.booksManager.service.BookShelfFavouriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelf-favourites")
public class BookShelfFavouriteController {
    private final BookShelfFavouriteService bookShelfFavouriteService;

    @PostMapping
    public ResponseEntity<BookShelfFavouriteResponseDto> add(
            @RequestBody BookShelfFavouriteRequestDto requestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookShelfFavouriteService.save(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<BookShelfFavouriteResponseDto>> findAll() {
        return ResponseEntity.ok(bookShelfFavouriteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookShelfFavouriteResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookShelfFavouriteService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookShelfFavouriteResponseDto> update(
            @PathVariable Long id,
            @RequestBody BookShelfFavouriteRequestDto requestDto
    ) {
        return ResponseEntity.accepted()
                .body(bookShelfFavouriteService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookShelfFavouriteService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
