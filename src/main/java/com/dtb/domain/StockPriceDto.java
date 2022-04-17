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
public class StockPriceDto {
    private String shortName;
    private String currency;
    private String exchangeName;
    private String symbol;
    private double price;
}
