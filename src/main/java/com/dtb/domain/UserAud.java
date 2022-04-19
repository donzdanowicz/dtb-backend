package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="USERS_AUD")
public class UserAud {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="EVENT_ID", unique = true)
    private Long eventId;

    @NotNull
    @Column(name="EVENT_DATE")
    private LocalDate eventDate;

    @NotNull
    @Column(name="EVENT_TYPE")
    private String eventType;

    @NotNull
    @Column(name="USER_ID")
    private Long userId;

    @Column(name="OLD_FIRST_NAME")
    private String oldFirstName;

    @Column(name="NEW_FIRST_NAME")
    private String newFirstName;

    @Column(name="OLD_LAST_NAME")
    private String oldLastName;

    @Column(name="NEW_LAST_NAME")
    private String newLastName;

    @Column(name="OLD_CREATED")
    private LocalDateTime oldCreated;

    @Column(name="NEW_CREATED")
    private LocalDateTime newCreated;

    @Column(name="OLD_CURRENCY")
    private String oldCurrency;

    @Column(name="NEW_CURRENCY")
    private String newCurrency;
}
