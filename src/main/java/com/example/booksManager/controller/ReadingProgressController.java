package com.example.booksManager.controller;

import com.example.booksManager.dto.readingProgress.ReadingProgressRequestDto;
import com.example.booksManager.dto.readingProgress.ReadingProgressResponseDto;
import com.example.booksManager.service.ReadingProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelf-book-reading-progresses")
public class ReadingProgressController {
    private final ReadingProgressService readingProgressService;

    @PostMapping
    public ResponseEntity<ReadingProgressResponseDto> add(
            @RequestBody ReadingProgressRequestDto requestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(readingProgressService.save(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<ReadingProgressResponseDto>> findAll() {
        return ResponseEntity.ok(readingProgressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadingProgressResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(readingProgressService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReadingProgressResponseDto> update(
            @PathVariable Long id,
            @RequestBody ReadingProgressRequestDto requestDto
    ) {
        return ResponseEntity.accepted()
                .body(readingProgressService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        readingProgressService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
