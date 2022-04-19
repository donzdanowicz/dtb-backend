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
@Table(name="NET_WORTH_AUD")
public class NetWorthAud {
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
    @Column(name="NET_WORTH_ID")
    private Long netWorthId;

    @Column(name="OLD_REAL_ESTATE")
    private double oldRealEstate;

    @Column(name="NEW_REAL_ESTATE")
    private double newRealEstate;

    @Column(name="OLD_CASH")
    private double oldCash;

    @Column(name="NEW_CASH")
    private double newCash;

    @Column(name="OLD_VEHICLES")
    private double oldVehicles;

    @Column(name="NEW_VEHICLES")
    private double newVehicles;

    @Column(name="OLD_SAVINGS_AND_INVESTMENTS")
    private double oldSavingsAndInvestments;

    @Column(name="NEW_SAVINGS_AND_INVESTMENTS")
    private double newSavingsAndInvestments;

    @Column(name="OLD_FOREIGN_CURRENCIES")
    private double oldForeignCurrencies;

    @Column(name="NEW_FOREIGN_CURRENCIES")
    private double newForeignCurrencies;

    @Column(name="OLD_STOCKS")
    private double oldStocks;

    @Column(name="NEW_STOCKS")
    private double newStocks;

    @Column(name="OLD_COLLECTIONS")
    private double oldCollections;

    @Column(name="NEW_COLLECTIONS")
    private double newCollections;

    @Column(name="OLD_HOME_CONTENT")
    private double oldHomeContent;

    @Column(name="NEW_HOME_CONTENT")
    private double newHomeContent;

    @Column(name="OLD_OTHER_ASSETS")
    private double oldOtherAssets;

    @Column(name="NEW_OTHER_ASSETS")
    private double newOtherAssets;

    @Column(name="OLD_MORTGAGE")
    private double oldMortgage;

    @Column(name="NEW_MORTGAGE")
    private double newMortgage;

    @Column(name="OLD_LOANS")
    private double oldLoans;

    @Column(name="NEW_LOANS")
    private double newLoans;

    @Column(name="OLD_CREDIT_CARDS")
    private double oldCreditCards;

    @Column(name="NEW_CREDIT_CARDS")
    private double newCreditCards;

    @Column(name="OLD_OTHER_LIABILITIES")
    private double oldOtherLiabilities;

    @Column(name="NEW_OTHER_LIABILITIES")
    private double newOtherLiabilities;

    @Column(name="OLD_DATE")
    private LocalDate oldDate;

    @Column(name="NEW_DATE")
    private LocalDate newDate;

    @Column(name="OLD_TOTAL_ASSETS")
    private double oldTotalAssets;

    @Column(name="NEW_TOTAL_ASSETS")
    private double newTotalAssets;

    @Column(name="OLD_TOTAL_LIABILITIES")
    private double oldTotalLiabilities;

    @Column(name="NEW_TOTAL_LIABILITIES")
    private double newTotalLiabilities;

    @Column(name="OLD_TOTAL_NET_WORTH")
    private double oldTotalNetWorth;

    @Column(name="NEW_TOTAL_NET_WORTH")
    private double newTotalNetWorth;

    @Column(name="OLD_USER_ID")
    private Long oldUserId;

    @Column(name="NEW_USER_ID")
    private Long newUserId;


}
