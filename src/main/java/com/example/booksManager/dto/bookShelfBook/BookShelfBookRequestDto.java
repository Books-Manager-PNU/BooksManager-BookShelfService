package com.example.booksManager.dto.bookShelfBook;

import jakarta.validation.constraints.NotBlank;

public record BookShelfBookRequestDto(

        @NotBlank(message = "bookShelf id cannot be empty")
        Long bookShelfId,

        @NotBlank(message = "book id cannot be empty")
        Long bookId
) {

}
