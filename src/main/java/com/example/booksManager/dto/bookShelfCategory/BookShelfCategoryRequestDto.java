package com.example.booksManager.dto.bookShelfCategory;

import jakarta.validation.constraints.NotBlank;

public record BookShelfCategoryRequestDto(
        @NotBlank(message = "category name cannot be empty")
        String name
) {

}
