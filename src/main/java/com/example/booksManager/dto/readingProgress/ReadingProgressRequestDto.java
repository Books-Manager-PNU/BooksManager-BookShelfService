package com.example.booksManager.dto.readingProgress;

import com.example.booksManager.entity.BookShelfBook;
import com.example.booksManager.entity.BookShelfCategory;
import jakarta.validation.constraints.NotBlank;

public record ReadingProgressRequestDto(
        long id,

        @NotBlank(message = "bookshelf book id cannot be empty")
        BookShelfBook bookshelfBookId,

        @NotBlank(message = "read pages cannot be empty")
        int readPages


) {

}
