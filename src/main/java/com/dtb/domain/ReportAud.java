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
@Table(name="REPORTS_AUD")
public class ReportAud {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="EVENT_ID", unique = true)
    private Long eventId;

    @NotNull
    @Column(name="EVENT_DATE")
    private LocalDate eventDate;

    @Column(name="INCOME")
    private double income;

    @Column(name="FOOD")
    private double food;

    @Column(name="HOUSING")
    private double housing;

    @Column(name="TRANSPORTATION")
    private double transportation;

    @Column(name="HEALTHCARE")
    private double healthcare;

    @Column(name="PERSONAL")
    private double personal;

    @Column(name="KIDS")
    private double kids;

    @Column(name="ENTERTAINMENT")
    private double entertainment;

    @Column(name="MISCELLANEOUS")
    private double miscellaneous;

    @Column(name="TRAVEL")
    private double travel;

    @Column(name="DEBTS")
    private double debts;

    @Column(name="SAVING_AND_INVESTING")
    private double savingAndInvesting;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="TYPE")
    private EntryType type;

    @Column(name="FROM_DATE")
    private LocalDate fromDate;

    @Column(name="TO_DATE")
    private LocalDate toDate;

    @Column(name="USER_ID")
    private Long userId;
}
