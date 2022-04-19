package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="STOCK_PRICE_AUD")
public class StockPriceAud {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="EVENT_ID", unique = true)
    private Long eventId;

    @NotNull
    @Column(name="EVENT_DATE")
    private LocalDate eventDate;

    @Column(name="SHORT_NAME")
    private String shortName;

    @Column(name="CURRENCY")
    private String currency;

    @Column(name="EXCHANGE_NAME")
    private String exchangeName;

    @Column(name="SYMBOL")
    private String symbol;

    @Column(name="PRICE")
    private double price;
}
