package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Month;

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

    @ManyToOne
    @JoinColumn(name="SUBCATEGORY_ID")
    private Subcategory subcategory;
}
