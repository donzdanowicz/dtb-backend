package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="NET_WORTH")
public class NetWorth {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique = true)
    private Long id;

    @Column(name="REAL_ESTATE")
    private double realEstate;

    @Column(name="CASH")
    private double cash;

    @Column(name="VEHICLES")
    private double vehicles;

    @Column(name="SAVINGS_AND_INVESTMENTS")
    private double savingsAndInvestments;

    @Column(name="FOREIGN_CURRENCIES")
    private double foreignCurrencies;

    @Column(name="STOCKS")
    private double stocks;

    @Column(name="COLLECTIONS")
    private double collections;

    @Column(name="HOME_CONTENT")
    private double homeContent;

    @Column(name="OTHER_ASSETS")
    private double otherAssets;

    @Column(name="MORTGAGE")
    private double mortgage;

    @Column(name="LOANS")
    private double loans;

    @Column(name="CREDIT_CARDS")
    private double creditCards;

    @Column(name="OTHER_LIABILITIES")
    private double otherLiabilities;

    @NotNull
    @Column(name="MONTH")
    private int month;

    @NotNull
    @Column(name="YEAR")
    private int year;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;
}