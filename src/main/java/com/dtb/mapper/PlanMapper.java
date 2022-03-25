package com.dtb.mapper;

import com.dtb.domain.Plan;
import com.dtb.domain.PlanDto;
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
public class PlanMapper {
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;

    public Plan mapToPlan(final PlanDto planDto) throws CategoryNotFoundException, UserNotFoundException {
        return Plan.builder()
                .id(planDto.getId())
                .value(planDto.getValue())
                .month(planDto.getMonth())
                .category(categoryRepository.findByName(planDto.getCategoryName())
                        .orElseThrow(CategoryNotFoundException::new))
                .user(userRepository.findById(planDto.getUserId()).orElseThrow(UserNotFoundException::new))
                .build();
    }

    public PlanDto mapToPlanDto(final Plan plan) {
        return PlanDto.builder()
                .id(plan.getId())
                .value(plan.getValue())
                .month(plan.getMonth())
                .categoryName(plan.getCategory().getName())
                .userId(plan.getUser().getId())
                .build();
    }

    public List<PlanDto> mapToPlanDtoList(final List<Plan> plans) {
        return plans.stream()
                .map(this::mapToPlanDto)
                .collect(Collectors.toList());
    }
}
