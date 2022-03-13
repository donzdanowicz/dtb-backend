package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PlanDto {
    private Long id;
    private double value;
    private Month month;
    private Long subcategoryId;
}
