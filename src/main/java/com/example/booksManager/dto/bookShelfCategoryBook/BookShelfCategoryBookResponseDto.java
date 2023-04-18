package com.example.booksManager.dto.bookShelfCategoryBook;

import com.example.booksManager.entity.BookShelfBook;
import com.example.booksManager.entity.BookShelfCategory;
import jakarta.validation.constraints.NotBlank;

public record BookShelfCategoryBookResponseDto(
        long id,

        BookShelfBook bookshelfBookId,

        BookShelfCategory bookShelfCategoryId
) {
}
