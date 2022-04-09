package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedNativeQuery(
        name = "Report.report",
        query = "SELECT ID, MONTH(CREATED) AS MONTH, YEAR(CREATED) AS YEAR, TYPE,\n" +
                "       SUM(INCOME) AS INCOME, SUM(FOOD) AS FOOD, SUM(HOUSING) AS HOUSING,\n" +
                "       SUM(TRANSPORTATION) AS TRANSPORTATION, SUM(HEALTHCARE) AS HEALTHCARE, SUM(PERSONAL) AS PERSONAL,\n" +
                "       SUM(KIDS) AS KIDS, SUM(ENTERTAINMENT) AS ENTERTAINMENT, SUM(MISCELLANEOUS) AS MISCELLANEOUS,\n" +
                "       SUM(TRAVEL) AS TRAVEL, SUM(DEBTS) AS DEBTS, SUM(SAVING_AND_INVESTING) AS SAVING_AND_INVESTING,\n" +
                "       USER_ID\n" +
                "FROM ENTRIES\n" +
                "WHERE MONTH(created) = 4 AND YEAR(created) = 2021\n" +
                "GROUP BY TYPE, MONTH(CREATED), YEAR(CREATED)\n" +
                "ORDER BY CREATED, TYPE",
        resultClass = Report.class
)

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="REPORTS")
public class Report {

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
    @Column(name="MONTH")
    private int month;

    @NotNull
    @Column(name="YEAR")
    private int year;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;
}
