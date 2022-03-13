package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="SUBCATEGORIES")
public class Subcategory {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique = true)
    private Long id;

    @GeneratedValue
    @NotNull
    @Column(name="ORDINAL_NUMBER", unique = true)
    private int ordinalNumber;

    @NotNull
    @Column(name="NAME")
    private String name;

    @OneToMany(
            targetEntity = Entry.class,
            mappedBy = "subcategory",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Entry> entries;

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

    @OneToMany(
            targetEntity = Entry.class,
            mappedBy = "subcategory",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Plan> plans;
}
