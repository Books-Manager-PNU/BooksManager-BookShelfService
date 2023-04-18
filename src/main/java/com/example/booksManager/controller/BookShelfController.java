package com.example.booksManager.controller;

import com.example.booksManager.dto.bookShelf.BookShelfRequestDto;
import com.example.booksManager.dto.bookShelf.BookShelfResponseDto;
import com.example.booksManager.service.BookShelfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelves")
public class BookShelfController {
    private final BookShelfService bookShelfService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookShelfResponseDto addBookShelf(@RequestBody BookShelfRequestDto bookShelfDto) {
        return bookShelfService.save(bookShelfDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookShelfResponseDto> findAll() {
        return bookShelfService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookShelfResponseDto findById(@PathVariable long id) {
        return bookShelfService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookShelfResponseDto updateBookShelfById(@PathVariable long id, @RequestBody BookShelfRequestDto bookDto) {
        return bookShelfService.update(id, bookDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookShelfById(@PathVariable long id) {
        bookShelfService.remove(id);
    }

}
