package com.example.booksManager.dto.bookShelf;

import jakarta.validation.constraints.NotBlank;

public record BookShelfRequestDto(
        @NotBlank(message = "title cannot be empty")
        String name,
        @NotBlank(message = "userId cannot be empty")
        Long userId
) {

}
