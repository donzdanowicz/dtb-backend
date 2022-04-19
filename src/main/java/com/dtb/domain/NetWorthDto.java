package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
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
    private double totalAssets;
    private double totalLiabilities;
    private double totalNetWorth;
    private LocalDate date;
    private Long userId;

//    private NetWorthDto (NetWorthDtoBuilder builder) {
//        this.id = builder.id;
//        this.realEstate = builder.realEstate;
//        this.cash = builder.cash;
//        this.vehicles = builder.vehicles;
//        this.savingsAndInvestments = builder.savingsAndInvestments;
//        this.foreignCurrencies = builder.foreignCurrencies;
//        this.stocks = builder.stocks;
//        this.collections = builder.collections;
//        this.homeContent = builder.homeContent;
//        this.otherAssets = builder.otherAssets;
//        this.mortgage = builder.mortgage;
//        this.loans = builder.loans;
//        this.creditCards = builder.creditCards;
//        this.otherLiabilities = builder.otherLiabilities;
//        this.date = builder.date;
//        this.userId = builder.userId;
//    }
//
//    public static class NetWorthDtoBuilder {
//        private Long id;
//        private double realEstate;
//        private double cash;
//        private double vehicles;
//        private double savingsAndInvestments;
//        private double foreignCurrencies;
//        private double stocks;
//        private double collections;
//        private double homeContent;
//        private double otherAssets;
//        private double mortgage;
//        private double loans;
//        private double creditCards;
//        private double otherLiabilities;
//        private LocalDate date;
//        private double totalAssets;
//        private double totalLiabilities;
//        private double totalNetWorth;
//        private Long userId;

//        public NetWorthDtoBuilder() {
//
//        }
//
//        public NetWorthDtoBuilder id(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public NetWorthDtoBuilder realEstate(double realEstate) {
//            this.realEstate = realEstate;
//            return this;
//        }
//
//        public NetWorthDtoBuilder cash(double cash) {
//            this.cash = cash;
//            return this;
//        }
//
//        public NetWorthDtoBuilder vehicles(double vehicles) {
//            this.vehicles = vehicles;
//            return this;
//        }
//
//        public NetWorthDtoBuilder savingsAndInvestments(double savingsAndInvestments) {
//            this.savingsAndInvestments = savingsAndInvestments;
//            return this;
//        }
//
//        public NetWorthDtoBuilder foreignCurrencies(double foreignCurrencies) {
//            this.foreignCurrencies = foreignCurrencies;
//            return this;
//        }
//
//        public NetWorthDtoBuilder stocks(double stocks) {
//            this.stocks = stocks;
//            return this;
//        }
//
//        public NetWorthDtoBuilder collections(double collections) {
//            this.collections = collections;
//            return this;
//        }
//
//        public NetWorthDtoBuilder homeContent(double homeContent) {
//            this.homeContent = homeContent;
//            return this;
//        }
//
//        public NetWorthDtoBuilder otherAssets(double otherAssets) {
//            this.otherAssets = otherAssets;
//            return this;
//        }
//
//        public NetWorthDtoBuilder mortgage(double mortgage) {
//            this.mortgage = mortgage;
//            return this;
//        }
//
//        public NetWorthDtoBuilder loans(double loans) {
//            this.loans = loans;
//            return this;
//        }
//
//        public NetWorthDtoBuilder creditCards(double creditCards) {
//            this.creditCards = creditCards;
//            return this;
//        }
//
//        public NetWorthDtoBuilder otherLiabilities(double otherLiabilities) {
//            this.otherLiabilities = otherLiabilities;
//            return this;
//        }
//
//        public NetWorthDtoBuilder date(LocalDate date) {
//            this.date = date;
//            return this;
//        }
//
//        public NetWorthDtoBuilder totalAssets(double totalAssets) {
//            this.totalAssets = totalAssets;
//            return this;
//        }
//
//        public NetWorthDtoBuilder totalLiabilities(double totalLiabilities) {
//            this.totalLiabilities = totalLiabilities;
//            return this;
//        }
//
//        public NetWorthDtoBuilder totalNetWorth(double totalNetWorth) {
//            this.totalNetWorth = totalNetWorth;
//            return this;
//        }
//
//        public NetWorthDtoBuilder userId(Long userId) {
//            this.userId = userId;
//            return this;
//        }
//
//        public NetWorthDto build() {
//            return new NetWorthDto(this);
//        }
//
//    }

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
