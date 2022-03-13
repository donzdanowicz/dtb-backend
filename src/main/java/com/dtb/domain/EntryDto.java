package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EntryDto {
    private Long id;
    private String name;
    private double value;
    private LocalDateTime created;
    private Long subcategoryId;
}
