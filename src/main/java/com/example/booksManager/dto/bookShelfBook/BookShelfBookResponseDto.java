package com.example.booksManager.dto.bookShelfBook;

public record BookShelfBookResponseDto(
        Long id,
        Long bookId,
        Long bookShelfId
) {
}
