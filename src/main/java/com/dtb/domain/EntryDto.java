package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EntryDto {
    private Long id;
    private double income;
    private double food;
    private double housing;
    private double transportation;
    private double healthcare;
    private double personal;
    private double kids;
    private double entertainment;
    private double miscellaneous;
    private double travel;
    private double debts;
    private double savingAndInvesting;
    private String description;
    private EntryType type;
    private LocalDate created;
    private Long userId;
}
