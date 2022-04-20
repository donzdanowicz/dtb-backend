package com.dtb.service;

import com.dtb.domain.CurrencyAud;
import com.dtb.domain.EntryAud;
import com.dtb.domain.EntryType;
import com.dtb.repository.CurrencyAudRepository;
import com.dtb.repository.EntryAudRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EntryAudDbServiceTestSuite {

    @InjectMocks
    EntryAudDbService entryAudDbService;

    @Mock
    EntryAudRepository entryAudRepository;

    @Test
    void saveEntryAud() {
        //Given
        EntryAud entryAud = EntryAud.builder()
                .eventDate(LocalDate.now())
                .eventType("INSERT")
                .entryId(1L)
                .newIncome(10000)
                .newFood(700)
                .newHousing(1000)
                .newTransportation(300)
                .newHealthcare(400)
                .newPersonal(400)
                .newKids(800)
                .newEntertainment(200)
                .newMiscellaneous(500)
                .newTravel(1000)
                .newDebts(0)
                .newSavingAndInvesting(5000)
                .newType(EntryType.PLAN)
                .newDate(LocalDate.of(2022,4,3))
                .newUserId(1L)
                .build();

        when(entryAudRepository.findById(1L)).thenReturn(Optional.of(entryAud));

        //When
        entryAudDbService.saveEntryAud(entryAud);

        //Then
        assertEquals("INSERT", entryAudRepository.findById(1L).get().getEventType());
        assertEquals(1L, entryAudRepository.findById(1L).get().getEntryId());
        assertEquals(10000, entryAudRepository.findById(1L).get().getNewIncome());
        assertEquals(700, entryAudRepository.findById(1L).get().getNewFood());
        assertEquals(1000, entryAudRepository.findById(1L).get().getNewHousing());
        assertEquals(300, entryAudRepository.findById(1L).get().getNewTransportation());
        assertEquals(400, entryAudRepository.findById(1L).get().getNewHealthcare());
        assertEquals(400, entryAudRepository.findById(1L).get().getNewPersonal());
        assertEquals(800, entryAudRepository.findById(1L).get().getNewKids());
        assertEquals(200, entryAudRepository.findById(1L).get().getNewEntertainment());
        assertEquals(500, entryAudRepository.findById(1L).get().getNewMiscellaneous());
        assertEquals(1000, entryAudRepository.findById(1L).get().getNewTravel());
        assertEquals(0, entryAudRepository.findById(1L).get().getNewDebts());
        assertEquals(5000, entryAudRepository.findById(1L).get().getNewSavingAndInvesting());
        assertEquals(EntryType.PLAN, entryAudRepository.findById(1L).get().getNewType());
        assertEquals(LocalDate.of(2022, 4, 3), entryAudRepository.findById(1L).get().getNewDate());
        assertEquals(1L, entryAudRepository.findById(1L).get().getNewUserId());
    }
}
