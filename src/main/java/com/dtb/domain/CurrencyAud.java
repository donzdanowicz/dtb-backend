package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="CURRENCIES_AUD")
public class CurrencyAud {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="EVENT_ID", unique = true)
    private Long eventId;

    @NotNull
    @Column(name="EVENT_DATE")
    private LocalDate eventDate;

    @NotNull
    @Column(name="EVENT_TYPE")
    private String eventType;

    @NotNull
    @Column(name="CURRENCY_ID")
    private Long currencyId;

    @Column(name="OLD_FROM")
    private String oldFrom;

    @Column(name="NEW_FROM")
    private String newFrom;

    @Column(name="OLD_TO")
    private String oldTo;

    @Column(name="NEW_TO")
    private String newTo;

    @Column(name="OLD_RATE")
    private double oldRate;

    @Column(name="NEW_RATE")
    private double newRate;

    @Column(name="OLD_AMOUNT")
    private double oldAmount;

    @Column(name="NEW_AMOUNT")
    private double newAmount;

    @Column(name="OLD_CONVERTED_AMOUNT")
    private double oldConvertedAmount;

    @Column(name="NEW_CONVERTED_AMOUNT")
    private double newConvertedAmount;

    @Column(name="OLD_CREATED")
    private LocalDateTime oldCreated;

    @Column(name="NEW_CREATED")
    private LocalDateTime newCreated;

}
