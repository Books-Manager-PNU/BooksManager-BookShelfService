package com.example.booksManager.mapper;

import com.example.booksManager.dto.bookshelfFavourite.BookShelfFavouriteRequestDto;
import com.example.booksManager.dto.bookshelfFavourite.BookShelfFavouriteResponseDto;
import com.example.booksManager.entity.BookShelfFavourite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookShelfFavouriteMapper {
    BookShelfFavouriteResponseDto toResponseDto(BookShelfFavourite favourite);

    BookShelfFavourite toEntity(BookShelfFavouriteRequestDto favourite);

    @Mapping(target = "id", ignore = true)
    void updateEntity(BookShelfFavouriteRequestDto favouriteDto, @MappingTarget BookShelfFavourite favourite);
}
