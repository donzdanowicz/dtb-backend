package com.dtb.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="USERS")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique = true)
    private Long id;

    @NotNull
    @Column(name="FIRST_NAME")
    private String firstName;

    @NotNull
    @Column(name="LAST_NAME")
    private String lastName;

    @NotNull
    @Column(name="CREATED")
    private LocalDateTime created = LocalDateTime.now();

    @NotNull
    @Column(name="CURRENCY")
    private String currency;

    /*@OneToMany(
            targetEntity = Entry.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Entry> entries;

    public User(Long id, String firstName, String lastName, LocalDateTime created, String currency) {
    }*/
}
