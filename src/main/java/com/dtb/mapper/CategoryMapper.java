package com.dtb.mapper;

import com.dtb.domain.Category;
import com.dtb.domain.CategoryDto;
import com.dtb.exception.UserNotFoundException;
import com.dtb.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryMapper {
    private UserRepository userRepository;

    public Category mapToCategory(final CategoryDto categoryDto) throws UserNotFoundException {
        return Category.builder()
                .id(categoryDto.getId())
                .ordinalNumber(categoryDto.getOrdinalNumber())
                .name(categoryDto.getName())
                .tag(categoryDto.getTag())
                .type(categoryDto.getType())
                .user(userRepository.findById(categoryDto.getUserId()).orElseThrow(UserNotFoundException::new))
                .build();
    }

    public CategoryDto mapToCategoryDto(final Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .ordinalNumber(category.getOrdinalNumber())
                .name(category.getName())
                .tag(category.getTag())
                .type(category.getType())
                .userId(category.getUser().getId())
                .build();
    }

    public List<CategoryDto> mapToCategoryDtoList(final List<Category> categories) {
        return categories.stream()
                .map(this::mapToCategoryDto)
                .collect(Collectors.toList());
    }
}
