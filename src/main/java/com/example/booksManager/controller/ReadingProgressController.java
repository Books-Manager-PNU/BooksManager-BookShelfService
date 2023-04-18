package com.example.booksManager.controller;

import com.example.booksManager.dto.bookshelfFavourite.BookShelfFavouriteRequestDto;
import com.example.booksManager.dto.bookshelfFavourite.BookShelfFavouriteResponseDto;
import com.example.booksManager.dto.readingProgress.ReadingProgressRequestDto;
import com.example.booksManager.dto.readingProgress.ReadingProgressResponseDto;
import com.example.booksManager.service.ReadingProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelves/books/reading-progresses")
public class ReadingProgressController {
    private final ReadingProgressService readingProgressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReadingProgressResponseDto addBookShelf(@RequestBody ReadingProgressRequestDto readingProgressDto) {
        return readingProgressService.save(readingProgressDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReadingProgressResponseDto> findAll() {
        return readingProgressService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReadingProgressResponseDto findById(@PathVariable long id) {
        return readingProgressService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ReadingProgressResponseDto updateBookShelfById(@PathVariable long id,
                                                             @RequestBody ReadingProgressRequestDto readingProgressDto) {
        return readingProgressService.update(id, readingProgressDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookShelfById(@PathVariable long id) {
        readingProgressService.remove(id);
    }

}
