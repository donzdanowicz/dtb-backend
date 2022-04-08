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
@Table(name="CATEGORIES")
public class Category {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique = true)
    private Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="ordinal_number_generator", sequenceName = "category_ordinal_seq", initialValue = 1)
    @NotNull
    @Column(name="ORDINAL_NUMBER", unique = true)
    private int ordinalNumber;

    @NotNull
    @Column(name="NAME", unique = true)
    private String name;

    @NotNull
    @Column(name="TAG")
    private String tag;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="TYPE")
    private CategoryType type;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @OneToMany(
            targetEntity = Entry.class,
            mappedBy = "category",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Entry> entries;

    /*@OneToMany(
            targetEntity = Plan.class,
            mappedBy = "category",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Plan> plans;*/
}
