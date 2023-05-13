package com.example.booksManager.mapper;

import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryRequestDto;
import com.example.booksManager.dto.bookShelfCategory.BookShelfCategoryResponseDto;
import com.example.booksManager.entity.BookShelfCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookShelfCategoryMapper {
    BookShelfCategoryResponseDto toResponseDto(BookShelfCategory category);

    BookShelfCategory toEntity(BookShelfCategoryRequestDto category);

    @Mapping(target = "id", ignore = true)
    void updateEntity(BookShelfCategoryRequestDto categoryDto, @MappingTarget BookShelfCategory category);
}
