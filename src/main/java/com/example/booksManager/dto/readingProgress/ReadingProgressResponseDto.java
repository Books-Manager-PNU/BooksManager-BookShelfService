package com.example.booksManager.dto.readingProgress;

public record ReadingProgressResponseDto(
        Long id,

        Long bookshelfBookId,

        int readPages
) {
}
