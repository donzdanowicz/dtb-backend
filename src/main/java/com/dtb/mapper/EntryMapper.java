package com.dtb.mapper;

import com.dtb.domain.Entry;
import com.dtb.domain.EntryDto;
import com.dtb.exception.CategoryNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.repository.CategoryRepository;
import com.dtb.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EntryMapper {
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;

    public Entry mapToEntry(final EntryDto entryDto) throws CategoryNotFoundException, UserNotFoundException {
        return Entry.builder()
                .id(entryDto.getId())
                .name(entryDto.getName())
                .value(entryDto.getValue())
                .created(entryDto.getCreated())
                .category(categoryRepository.findByName(entryDto.getCategoryName())
                        .orElseThrow(CategoryNotFoundException::new))
                .user(userRepository.findById(entryDto.getUserId()).orElseThrow(UserNotFoundException::new))
                .build();
    }

    public EntryDto mapToEntryDto(final Entry entry) {
        return EntryDto.builder()
                .id(entry.getId())
                .name(entry.getName())
                .value(entry.getValue())
                .created(entry.getCreated())
                .categoryName(entry.getCategory().getName())
                .userId(entry.getUser().getId())
                .build();
    }

    public List<EntryDto> mapToEntryDtoList(final List<Entry> entries) {
        return entries.stream()
                .map(this::mapToEntryDto)
                .collect(Collectors.toList());
    }
}
