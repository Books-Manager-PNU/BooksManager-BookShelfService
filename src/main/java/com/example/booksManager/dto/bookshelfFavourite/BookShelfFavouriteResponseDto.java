package com.example.booksManager.dto.bookshelfFavourite;

import com.example.booksManager.entity.BookShelfBook;
import com.example.booksManager.entity.BookShelfCategory;

public record BookShelfFavouriteResponseDto(
        long id,

        BookShelfBook bookshelfBookId
) {
}
