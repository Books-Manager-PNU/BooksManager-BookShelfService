package com.example.booksManager.dto.bookshelfFavourite;

import jakarta.validation.constraints.NotBlank;

public record BookShelfFavouriteRequestDto(
        @NotBlank(message = "bookshelf book id cannot be empty")
        Long bookshelfBookId
) {

}
