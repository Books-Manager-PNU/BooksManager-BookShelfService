package com.example.booksManager.controller;

import com.example.booksManager.dto.bookShelfBook.BookShelfBookRequestDto;
import com.example.booksManager.dto.bookShelfBook.BookShelfBookResponseDto;
import com.example.booksManager.service.BookShelfBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookshelves/books")
public class BookShelfBookController {
    private final BookShelfBookService bookShelfBookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookShelfBookResponseDto addBookShelfBook(@RequestBody BookShelfBookRequestDto bookShelfBookDto) {
        return bookShelfBookService.save(bookShelfBookDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookShelfBookResponseDto> findAll() {
        return bookShelfBookService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookShelfBookResponseDto findById(@PathVariable long id) {
        return bookShelfBookService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookShelfBookResponseDto updateBookShelfById(@PathVariable long id,
                                                        @RequestBody BookShelfBookRequestDto bookShelfBookDto) {
        return bookShelfBookService.update(id, bookShelfBookDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookShelfById(@PathVariable long id) {
        bookShelfBookService.remove(id);
    }

}
