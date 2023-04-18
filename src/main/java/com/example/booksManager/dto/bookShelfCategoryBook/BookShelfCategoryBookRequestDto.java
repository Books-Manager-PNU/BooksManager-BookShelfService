package com.example.booksManager.dto.bookShelfCategoryBook;

import com.example.booksManager.entity.BookShelfBook;
import com.example.booksManager.entity.BookShelfCategory;
import jakarta.validation.constraints.NotBlank;

public record BookShelfCategoryBookRequestDto(
        long id,

        @NotBlank(message = "bookshelf book id cannot be empty")
        BookShelfBook bookshelfBookId,
        @NotBlank(message = "bookshelf category id cannot be empty")
        BookShelfCategory bookShelfCategoryId


) {

}
