package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Month;


@NamedNativeQuery(
        name = "Plan.reportPlans",
        query = "SELECT ReportPlans()"
)

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="PLANS")
public class Plan {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique = true)
    private Long id;

    @NotNull
    @Column(name="VALUE")
    private double value;

    @NotNull
    @Column(name="MONTH")
    private Month month;

    @NotNull
    @Column(name="CATEGORY_ID")
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;
}
