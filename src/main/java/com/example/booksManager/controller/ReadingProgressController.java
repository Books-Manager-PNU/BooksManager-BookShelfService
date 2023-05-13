package com.example.booksManager.controller;

import com.example.booksManager.dto.readingProgress.ReadingProgressRequestDto;
import com.example.booksManager.dto.readingProgress.ReadingProgressResponseDto;
import com.example.booksManager.service.ReadingProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelf-book-reading-progresses")
public class ReadingProgressController {
    private final ReadingProgressService readingProgressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReadingProgressResponseDto addBookShelf(
            @RequestBody ReadingProgressRequestDto readingProgressDto,
            @RequestParam("user") Long userId
    ) {
        return readingProgressService.save(readingProgressDto, userId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReadingProgressResponseDto> findAll() {
        return readingProgressService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReadingProgressResponseDto findById(@PathVariable Long id) {
        return readingProgressService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ReadingProgressResponseDto updateBookShelfById(
            @PathVariable Long id,
            @RequestBody ReadingProgressRequestDto readingProgressDto,
            @RequestParam("user") Long userId
    ) {
        return readingProgressService.update(id, readingProgressDto, userId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookShelfById(@PathVariable Long id) {
        readingProgressService.remove(id);
    }

}
