package com.example.booksManager.dto.readingProgress;

import jakarta.validation.constraints.NotBlank;

public record ReadingProgressRequestDto(
        @NotBlank(message = "bookshelf book id cannot be empty")
        Long bookshelfBookId,

        @NotBlank(message = "read pages cannot be empty")
        int readPages


) {

}
