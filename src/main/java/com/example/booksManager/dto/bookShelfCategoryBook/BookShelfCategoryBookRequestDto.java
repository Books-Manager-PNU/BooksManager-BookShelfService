package com.example.booksManager.dto.bookShelfCategoryBook;

import jakarta.validation.constraints.NotBlank;

public record BookShelfCategoryBookRequestDto(
        @NotBlank(message = "bookshelf book id cannot be empty")
        Long bookshelfBookId,
        @NotBlank(message = "bookshelf category id cannot be empty")
        Long bookshelfCategoryId


) {

}
