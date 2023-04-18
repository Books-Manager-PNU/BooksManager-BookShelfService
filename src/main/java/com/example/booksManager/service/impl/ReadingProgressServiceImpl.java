package com.example.booksManager.service.impl;

import com.example.booksManager.dto.readingProgress.ReadingProgressRequestDto;
import com.example.booksManager.dto.readingProgress.ReadingProgressResponseDto;
import com.example.booksManager.entity.ReadingProgress;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.ReadingProgressMapper;
import com.example.booksManager.repository.ReadingProgressRepository;
import com.example.booksManager.service.ReadingProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadingProgressServiceImpl implements ReadingProgressService {
    private final ReadingProgressRepository readingProgressRepository;
    private final ReadingProgressMapper readingProgressMapper;

    @Override
    public ReadingProgressResponseDto save(ReadingProgressRequestDto readingProgressDto) {
        ReadingProgress readingProgress = readingProgressMapper.toEntity(readingProgressDto);
        return readingProgressMapper.toReadingProgressResponseDto(readingProgressRepository.save(readingProgress));
    }

    @Override
    public List<ReadingProgressResponseDto> findAll() {
        return readingProgressRepository.findAll()
                .stream()
                .map(readingProgressMapper::toReadingProgressResponseDto)
                .toList();
    }

    @Override
    public ReadingProgressResponseDto findById(long id) {
        ReadingProgress readingProgress = getExistingBookById(id);
        return readingProgressMapper.toReadingProgressResponseDto(readingProgressRepository.save(readingProgress));
    }

    @Override
    public ReadingProgressResponseDto update(long id, ReadingProgressRequestDto readingProgressDto) {
        ReadingProgress readingProgress = getExistingBookById(id);
        readingProgressMapper.updateEntity(readingProgressDto, readingProgress);
        readingProgressRepository.save(readingProgress);
        return readingProgressMapper.toReadingProgressResponseDto(readingProgress);
    }

    @Override
    public void remove(long id) {
        ReadingProgress readingProgress = getExistingBookById(id);
        readingProgressRepository.delete(readingProgress);
    }

    private ReadingProgress getExistingBookById(long id) {
        return readingProgressRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "ReadingProgress not found"));
    }
}
