package com.example.booksManager.dto.readingProgress;

import com.example.booksManager.entity.BookShelfBook;
import com.example.booksManager.entity.BookShelfCategory;
import jakarta.validation.constraints.NotBlank;

public record ReadingProgressResponseDto(
        long id,

        BookShelfBook bookshelfBookId,

        int readPages
) {
}
