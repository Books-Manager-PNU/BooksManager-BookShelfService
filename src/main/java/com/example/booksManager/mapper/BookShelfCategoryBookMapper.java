package com.example.booksManager.mapper;

import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryRequestDto;
import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryResponseDto;
import com.example.booksManager.dto.bookShelfCategoryBook.BookShelfCategoryBookRequestDto;
import com.example.booksManager.dto.bookShelfCategoryBook.BookShelfCategoryBookResponseDto;
import com.example.booksManager.entity.BookShelfCategory;
import com.example.booksManager.entity.BookShelfCategoryBook;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookShelfCategoryBookMapper {
    BookShelfCategoryBookResponseDto toBookShelfCategoryBookResponseDto(BookShelfCategoryBook categoryBook);
    BookShelfCategoryBook toEntity(BookShelfCategoryBookRequestDto categoryBook);

    @Mapping(target = "id", ignore = true)
    void updateEntity(BookShelfCategoryBookRequestDto categoryBookDto, @MappingTarget BookShelfCategoryBook categoryBook);
}
