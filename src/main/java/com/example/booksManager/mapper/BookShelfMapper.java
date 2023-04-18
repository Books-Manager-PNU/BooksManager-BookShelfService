package com.example.booksManager.mapper;

import com.example.booksManager.dto.bookShelf.BookShelfRequestDto;
import com.example.booksManager.dto.bookShelf.BookShelfResponseDto;
import com.example.booksManager.entity.BookShelf;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookShelfMapper {
    BookShelfResponseDto toBookShelfResponseDto(BookShelf bookShelf);
    BookShelf toEntity(BookShelfRequestDto bookShelf);

    @Mapping(target = "id", ignore = true)
    void updateEntity(BookShelfRequestDto bookDto, @MappingTarget BookShelf book);
}
