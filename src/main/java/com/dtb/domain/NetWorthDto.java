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
public class NetWorthDto {
    private Long id;
    private double realEstate;
    private double cash;
    private double vehicles;
    private double savingsAndInvestments;
    private double foreignCurrencies;
    private double stocks;
    private double collections;
    private double homeContent;
    private double otherAssets;
    private double mortgage;
    private double loans;
    private double creditCards;
    private double otherLiabilities;
    private int month;
    private int year;
    private Long userId;
}
