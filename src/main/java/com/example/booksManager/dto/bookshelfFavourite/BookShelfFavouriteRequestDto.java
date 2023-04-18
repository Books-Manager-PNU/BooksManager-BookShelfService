package com.example.booksManager.dto.bookshelfFavourite;

import com.example.booksManager.entity.BookShelfBook;
import com.example.booksManager.entity.BookShelfCategory;
import jakarta.validation.constraints.NotBlank;

public record BookShelfFavouriteRequestDto(
        long id,

        @NotBlank(message = "bookshelf book id cannot be empty")
        BookShelfBook bookshelfBookId
) {

}
