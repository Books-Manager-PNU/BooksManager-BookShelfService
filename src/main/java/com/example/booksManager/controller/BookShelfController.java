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
    public BookShelfResponseDto addBookShelf(
            @RequestBody BookShelfRequestDto bookShelfDto,
            @RequestParam("user") Long userId
    ) {
        return bookShelfService.save(bookShelfDto, userId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookShelfResponseDto> findAll() {
        return bookShelfService.findAll();
    }

    @GetMapping("/testAPI")
    @ResponseStatus(HttpStatus.OK)
    public String testApiGatewayEndpoint() {
        return "works fine! from bookshelf service";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookShelfResponseDto findById(@PathVariable Long id) {
        return bookShelfService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookShelfResponseDto updateBookShelfById(
            @PathVariable Long id,
            @RequestBody BookShelfRequestDto bookDto,
            @RequestParam("user") Long userId
    ) {
        return bookShelfService.update(id, bookDto, userId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookShelfById(@PathVariable Long id) {
        bookShelfService.remove(id);
    }

}
