package com.dtb.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NamedNativeQueries({
        @NamedNativeQuery(
        name="Entry.report",
        query = "SELECT ID, DATE, TYPE,\n" +
                "       SUM(INCOME) AS INCOME, SUM(FOOD) AS FOOD, SUM(HOUSING) AS HOUSING,\n" +
                "       SUM(TRANSPORTATION) AS TRANSPORTATION, SUM(HEALTHCARE) AS HEALTHCARE, SUM(PERSONAL) AS PERSONAL,\n" +
                "       SUM(KIDS) AS KIDS, SUM(ENTERTAINMENT) AS ENTERTAINMENT, SUM(MISCELLANEOUS) AS MISCELLANEOUS,\n" +
                "       SUM(TRAVEL) AS TRAVEL, SUM(DEBTS) AS DEBTS, SUM(SAVING_AND_INVESTING) AS SAVING_AND_INVESTING,\n" +
                "       USER_ID\n" +
                "FROM ENTRIES\n" +
                //"WHERE MONTH(created) = 4 AND YEAR(created) = 2021\n" +
                "GROUP BY TYPE, MONTH(DATE), YEAR(DATE)\n" +
                "ORDER BY YEAR(DATE), MONTH(DATE), TYPE",
        resultClass = Entry.class
        ),
        @NamedNativeQuery(name="Entry.reportByDate",
                query = "SELECT ID, DATE, TYPE,\n" +
                        "       SUM(INCOME) AS INCOME, SUM(FOOD) AS FOOD, SUM(HOUSING) AS HOUSING,\n" +
                        "       SUM(TRANSPORTATION) AS TRANSPORTATION, SUM(HEALTHCARE) AS HEALTHCARE, SUM(PERSONAL) AS PERSONAL,\n" +
                        "       SUM(KIDS) AS KIDS, SUM(ENTERTAINMENT) AS ENTERTAINMENT, SUM(MISCELLANEOUS) AS MISCELLANEOUS,\n" +
                        "       SUM(TRAVEL) AS TRAVEL, SUM(DEBTS) AS DEBTS, SUM(SAVING_AND_INVESTING) AS SAVING_AND_INVESTING,\n" +
                        "       USER_ID\n" +
                        "FROM ENTRIES\n" +
                        "WHERE DATE BETWEEN :BEGIN AND :END\n" +
                        "GROUP BY TYPE, MONTH(DATE), YEAR(DATE)\n" +
                        "ORDER BY DATE, TYPE;",
                resultClass = Entry.class
        )
        })

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="ENTRIES")
public class Entry {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique = true)
    private Long id;

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

    @NotNull
    @Column(name="DATE")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

//    private Entry (EntryBuilder builder) {
//        this.id = builder.id;
//        this.income = builder.income;
//        this.food = builder.food;
//        this.housing = builder.housing;
//        this.transportation = builder.transportation;
//        this.healthcare = builder.healthcare;
//        this.personal = builder.personal;
//        this.kids = builder.kids;
//        this.entertainment = builder.entertainment;
//        this.miscellaneous = builder.miscellaneous;
//        this.travel = builder.travel;
//        this.debts = builder.debts;
//        this.savingAndInvesting = builder.savingAndInvesting;
//        this.type = builder.type;
//        this.date = builder.date;
//        this.user = builder.user;
//    }
//
//    public static class EntryBuilder {
//        private Long id;
//        private double income;
//        private double food;
//        private double housing;
//        private double transportation;
//        private double healthcare;
//        private double personal;
//        private double kids;
//        private double entertainment;
//        private double miscellaneous;
//        private double travel;
//        private double debts;
//        private double savingAndInvesting;
//        private EntryType type;
//        private LocalDate date;
//        private User user;
//
//        public EntryBuilder() {
//
//        }
//
//        public EntryBuilder id(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public EntryBuilder income(double income) {
//            this.income = income;
//            return this;
//        }
//
//        public EntryBuilder food(double food) {
//            this.food = food;
//            return this;
//        }
//
//        public EntryBuilder housing(double housing) {
//            this.housing = housing;
//            return this;
//        }
//
//        public EntryBuilder transportation(double transportation) {
//            this.transportation = transportation;
//            return this;
//        }
//
//        public EntryBuilder healthcare(double healthcare) {
//            this.healthcare = healthcare;
//            return this;
//        }
//
//        public EntryBuilder personal(double personal) {
//            this.personal = personal;
//            return this;
//        }
//
//        public EntryBuilder kids(double kids) {
//            this.kids = kids;
//            return this;
//        }
//
//        public EntryBuilder entertainment(double entertainment) {
//            this.entertainment = entertainment;
//            return this;
//        }
//
//        public EntryBuilder miscellaneous(double miscellaneous) {
//            this.miscellaneous = miscellaneous;
//            return this;
//        }
//
//        public EntryBuilder travel(double travel) {
//            this.travel = travel;
//            return this;
//        }
//
//        public EntryBuilder debts(double debts) {
//            this.debts = debts;
//            return this;
//        }
//
//        public EntryBuilder savingAndInvesting(double savingAndInvesting) {
//            this.savingAndInvesting = savingAndInvesting;
//            return this;
//        }
//
//        public EntryBuilder type(EntryType type) {
//            this.type = type;
//            return this;
//        }
//
//        public EntryBuilder date(LocalDate date) {
//            this.date = date;
//            return this;
//        }
//
//        public EntryBuilder user(User user) {
//            this.user = user;
//            return this;
//        }
//
//        public Entry build() {
//            return new Entry(this);
//        }
//
//    }
}
