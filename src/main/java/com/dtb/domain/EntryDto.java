package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntryDto {
    private Long id;
    private double income;
    private double food;
    private double housing;
    private double transportation;
    private double healthcare;
    private double personal;
    private double kids;
    private double entertainment;
    private double miscellaneous;
    private double travel;
    private double debts;
    private double savingAndInvesting;
    private EntryType type;
    private int day;
    private int month;
    private int year;
    private Long userId;

    private EntryDto (EntryDtoBuilder builder) {
        this.id = builder.id;
        this.income = builder.income;
        this.food = builder.food;
        this.housing = builder.housing;
        this.transportation = builder.transportation;
        this.healthcare = builder.healthcare;
        this.personal = builder.personal;
        this.kids = builder.kids;
        this.entertainment = builder.entertainment;
        this.miscellaneous = builder.miscellaneous;
        this.travel = builder.travel;
        this.debts = builder.debts;
        this.savingAndInvesting = builder.savingAndInvesting;
        this.type = builder.type;
        this.day = builder.day;
        this.month = builder.month;
        this.year = builder.year;
        this.userId = builder.userId;
    }

    public static class EntryDtoBuilder {
        private Long id;
        private double income;
        private double food;
        private double housing;
        private double transportation;
        private double healthcare;
        private double personal;
        private double kids;
        private double entertainment;
        private double miscellaneous;
        private double travel;
        private double debts;
        private double savingAndInvesting;
        private EntryType type;
        private int day;
        private int month;
        private int year;
        private Long userId;

        public EntryDtoBuilder() {

        }

        public EntryDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public EntryDtoBuilder income(double income) {
            this.income = income;
            return this;
        }

        public EntryDtoBuilder food(double food) {
            this.food = food;
            return this;
        }

        public EntryDtoBuilder housing(double housing) {
            this.housing = housing;
            return this;
        }

        public EntryDtoBuilder transportation(double transportation) {
            this.transportation = transportation;
            return this;
        }

        public EntryDtoBuilder healthcare(double healthcare) {
            this.healthcare = healthcare;
            return this;
        }

        public EntryDtoBuilder personal(double personal) {
            this.personal = personal;
            return this;
        }

        public EntryDtoBuilder kids(double kids) {
            this.kids = kids;
            return this;
        }

        public EntryDtoBuilder entertainment(double entertainment) {
            this.entertainment = entertainment;
            return this;
        }

        public EntryDtoBuilder miscellaneous(double miscellaneous) {
            this.miscellaneous = miscellaneous;
            return this;
        }

        public EntryDtoBuilder travel(double travel) {
            this.travel = travel;
            return this;
        }

        public EntryDtoBuilder debts(double debts) {
            this.debts = debts;
            return this;
        }

        public EntryDtoBuilder savingAndInvesting(double savingAndInvesting) {
            this.savingAndInvesting = savingAndInvesting;
            return this;
        }

        public EntryDtoBuilder type(EntryType type) {
            this.type = type;
            return this;
        }

        public EntryDtoBuilder day(int day) {
            this.day = day;
            return this;
        }

        public EntryDtoBuilder month(int month) {
            this.month = month;
            return this;
        }

        public EntryDtoBuilder year(int year) {
            this.year = year;
            return this;
        }

        public EntryDtoBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public EntryDto build() {
            return new EntryDto(this);
        }

    }
}
