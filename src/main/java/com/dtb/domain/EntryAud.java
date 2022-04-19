package com.dtb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="ENTRIES_AUD")
public class EntryAud {
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
    @Column(name = "ENTRY_ID")
    private Long entryId;

    @Column(name="OLD_INCOME")
    private double oldIncome;

    @Column(name="NEW_INCOME")
    private double newIncome;

    @Column(name="OLD_FOOD")
    private double oldFood;

    @Column(name="NEW_FOOD")
    private double newFood;

    @Column(name="OLD_HOUSING")
    private double oldHousing;

    @Column(name="NEW_HOUSING")
    private double newHousing;

    @Column(name="OLD_TRANSPORTATION")
    private double oldTransportation;

    @Column(name="NEW_TRANSPORTATION")
    private double newTransportation;

    @Column(name="OLD_HEALTHCARE")
    private double oldHealthcare;

    @Column(name="NEW_HEALTHCARE")
    private double newHealthcare;

    @Column(name="OLD_PERSONAL")
    private double oldPersonal;

    @Column(name="NEW_PERSONAL")
    private double newPersonal;

    @Column(name="OLD_KIDS")
    private double oldKids;

    @Column(name="NEW_KIDS")
    private double newKids;

    @Column(name="OLD_ENTERTAINMENT")
    private double oldEntertainment;

    @Column(name="NEW_ENTERTAINMENT")
    private double newEntertainment;

    @Column(name="OLD_MISCELLANEOUS")
    private double oldMiscellaneous;

    @Column(name="NEW_MISCELLANEOUS")
    private double newMiscellaneous;

    @Column(name="OLD_TRAVEL")
    private double oldTravel;

    @Column(name="NEW_TRAVEL")
    private double newTravel;

    @Column(name="OLD_DEBTS")
    private double oldDebts;

    @Column(name="NEW_DEBTS")
    private double newDebts;

    @Column(name="OLD_SAVING_AND_INVESTING")
    private double oldSavingAndInvesting;

    @Column(name="NEW_SAVING_AND_INVESTING")
    private double newSavingAndInvesting;

    @Enumerated(EnumType.STRING)
    @Column(name="OLD_TYPE")
    private EntryType oldType;

    @Enumerated(EnumType.STRING)
    @Column(name="NEW_TYPE")
    private EntryType newType;

    @Column(name="OLD_DATE")
    private LocalDate oldDate;

    @Column(name="NEW_DATE")
    private LocalDate newDate;

    @Column(name="OLD_USER_ID")
    private Long oldUserId;

    @Column(name="NEW_USER_ID")
    private Long newUserId;
}
