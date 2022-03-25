package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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

    @NotNull
    @Column(name="NAME")
    private String name;

    @NotNull
    @Column(name="VALUE")
    private double value;

    @NotNull
    @Column(name="CREATED")
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name="CATEGORY_NAME")
    private Category category;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;
}
