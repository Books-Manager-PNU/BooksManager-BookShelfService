package com.example.booksManager.mapper;

import com.example.booksManager.dto.bookShelfBook.BookShelfBookRequestDto;
import com.example.booksManager.dto.bookShelfBook.BookShelfBookResponseDto;
import com.example.booksManager.entity.BookShelfBook;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookShelfBookMapper {
    BookShelfBookResponseDto toResponseDto(BookShelfBook bookShelf);

    BookShelfBook toEntity(BookShelfBookRequestDto bookShelf);

    @Mapping(target = "id", ignore = true)
    void updateEntity(BookShelfBookRequestDto bookDto, @MappingTarget BookShelfBook book);
}
