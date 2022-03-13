package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SubcategoryDto {
    private Long id;
    private int ordinalNumber;
    private String name;
    private Long categoryId;
}
