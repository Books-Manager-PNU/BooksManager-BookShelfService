package com.example.booksManager.mapper;

import com.example.booksManager.dto.readingProgress.ReadingProgressRequestDto;
import com.example.booksManager.dto.readingProgress.ReadingProgressResponseDto;
import com.example.booksManager.entity.ReadingProgress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReadingProgressMapper {
    ReadingProgressResponseDto toResponseDto(ReadingProgress readingProgress);

    ReadingProgress toEntity(ReadingProgressRequestDto readingProgress);

    @Mapping(target = "id", ignore = true)
    void updateEntity(ReadingProgressRequestDto readingProgressDto, @MappingTarget ReadingProgress readingProgress);
}
