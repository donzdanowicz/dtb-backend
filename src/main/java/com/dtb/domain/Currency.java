package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NamedNativeQuery(
        name = "Currency.getLatest10",
        query = "SELECT DISTINCT * FROM CURRENCIES\n" +
                "ORDER BY CREATED DESC\n" +
                "LIMIT 10;",
        resultClass = Currency.class
)

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="CURRENCIES")
public class Currency {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique = true)
    private Long id;

    @NotNull
    @Column(name="FROM_CURRENCY")
    private String fromCurrency;

    @NotNull
    @Column(name="TO_CURRENCY")
    private String toCurrency;

    @NotNull
    @Column(name="RATE")
    private double rate;

    @NotNull
    @Column(name="AMOUNT")
    private double amount;

    @Column(name="CONVERTED_AMOUNT")
    private double convertedAmount;

    @NotNull
    @Column(name="CREATED")
    private LocalDateTime created;
}
