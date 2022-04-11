package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @NotNull
    @Column(name="TOTAL_ASSETS")
    private double totalAssets;

    @NotNull
    @Column(name="TOTAL_LIABILITIES")
    private double totalLiabilities;

    @NotNull
    @Column(name="TOTAL_NET_WORTH")
    private double totalNetWorth;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    private NetWorth (NetWorthBuilder builder) {
        this.id = builder.id;
        this.realEstate = builder.realEstate;
        this.cash = builder.cash;
        this.vehicles = builder.vehicles;
        this.savingsAndInvestments = builder.savingsAndInvestments;
        this.foreignCurrencies = builder.foreignCurrencies;
        this.stocks = builder.stocks;
        this.collections = builder.collections;
        this.homeContent = builder.homeContent;
        this.otherAssets = builder.otherAssets;
        this.mortgage = builder.mortgage;
        this.loans = builder.loans;
        this.creditCards = builder.creditCards;
        this.otherLiabilities = builder.otherLiabilities;
        this.month = builder.month;
        this.year = builder.year;
        this.user = builder.user;
    }

    public static class NetWorthBuilder {
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
        private User user;

        public NetWorthBuilder() {

        }

        public NetWorthBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public NetWorthBuilder realEstate(double realEstate) {
            this.realEstate = realEstate;
            return this;
        }

        public NetWorthBuilder cash(double cash) {
            this.cash = cash;
            return this;
        }

        public NetWorthBuilder vehicles(double vehicles) {
            this.vehicles = vehicles;
            return this;
        }

        public NetWorthBuilder savingsAndInvestments(double savingsAndInvestments) {
            this.savingsAndInvestments = savingsAndInvestments;
            return this;
        }

        public NetWorthBuilder foreignCurrencies(double foreignCurrencies) {
            this.foreignCurrencies = foreignCurrencies;
            return this;
        }

        public NetWorthBuilder stocks(double stocks) {
            this.stocks = stocks;
            return this;
        }

        public NetWorthBuilder collections(double collections) {
            this.collections = collections;
            return this;
        }

        public NetWorthBuilder homeContent(double homeContent) {
            this.homeContent = homeContent;
            return this;
        }

        public NetWorthBuilder otherAssets(double otherAssets) {
            this.otherAssets = otherAssets;
            return this;
        }

        public NetWorthBuilder mortgage(double mortgage) {
            this.mortgage = mortgage;
            return this;
        }

        public NetWorthBuilder loans(double loans) {
            this.loans = loans;
            return this;
        }

        public NetWorthBuilder creditCards(double creditCards) {
            this.creditCards = creditCards;
            return this;
        }

        public NetWorthBuilder otherLiabilities(double otherLiabilities) {
            this.otherLiabilities = otherLiabilities;
            return this;
        }

        public NetWorthBuilder month(int month) {
            this.month = month;
            return this;
        }

        public NetWorthBuilder year(int year) {
            this.year = year;
            return this;
        }

        public NetWorthBuilder user(User user) {
            this.user = user;
            return this;
        }

        public NetWorth build() {
            return new NetWorth(this);
        }

    }

    public double calculateTotalAssets() {
        return getRealEstate() + getCash() + getVehicles() + getSavingsAndInvestments() + getForeignCurrencies()
                + getStocks() + getCollections() + getHomeContent() + getOtherAssets();
    }

    public double calculateTotalLiabilities() {
        return getMortgage() + getLoans() + getCreditCards() + getOtherLiabilities();
    }

    public double calculateTotalNetWorth() {
        return getTotalAssets() - getTotalLiabilities();
    }
}

