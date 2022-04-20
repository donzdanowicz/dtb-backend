package com.dtb.service;

import com.dtb.domain.*;
import com.dtb.repository.EntryAudRepository;
import com.dtb.repository.EntryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EntryDbServiceTestSuite {

    @InjectMocks
    EntryDbService entryDbService;

    @Mock
    EntryRepository entryRepository;

    @Test
    void getEntries() {
        //Given
        List<Entry> entries = new ArrayList<>();

        Entry entry1 = new Entry.EntryBuilder()
                .id(1L)
                .income(10000)
                .food(700)
                .housing(1000)
                .transportation(300)
                .healthcare(400)
                .personal(400)
                .kids(800)
                .entertainment(200)
                .miscellaneous(500)
                .travel(1000)
                .debts(0)
                .savingAndInvesting(5000)
                .type(EntryType.ENTRY)
                .date(LocalDate.of(2022, 4, 3))
                .user(new User())
                .build();

        Entry entry2 = new Entry.EntryBuilder()
                .id(2L)
                .income(10000)
                .food(700)
                .housing(1000)
                .transportation(300)
                .healthcare(400)
                .personal(400)
                .kids(800)
                .entertainment(200)
                .miscellaneous(500)
                .travel(1000)
                .debts(0)
                .savingAndInvesting(5000)
                .type(EntryType.PLAN)
                .date(LocalDate.of(2022, 4, 3))
                .user(new User())
                .build();

        entries.add(entry1);
        entries.add(entry2);

        when(entryRepository.findAll()).thenReturn(entries);

        //When
        List<Entry> result = entryDbService.getEntries();

        //Then
        assertEquals(2, result.size());
    }

    @Test
    void getEntry() {
        //Given
        Entry entry = new Entry.EntryBuilder()
                .id(1L)
                .income(10000)
                .food(700)
                .housing(1000)
                .transportation(300)
                .healthcare(400)
                .personal(400)
                .kids(800)
                .entertainment(200)
                .miscellaneous(500)
                .travel(1000)
                .debts(0)
                .savingAndInvesting(5000)
                .type(EntryType.PLAN)
                .date(LocalDate.of(2022, 4, 3))
                .user(new User())
                .build();

        when(entryRepository.findById(1L)).thenReturn(Optional.of(entry));

        //When
        Optional<Entry> result = entryDbService.getEntry(1L);

        //Then
        assertEquals(Optional.of(entry), entryDbService.getEntry(1L));
    }

    @Test
    void deleteEntry() {
        //Given
        Entry entry = new Entry.EntryBuilder()
                .id(1L)
                .income(10000)
                .food(700)
                .housing(1000)
                .transportation(300)
                .healthcare(400)
                .personal(400)
                .kids(800)
                .entertainment(200)
                .miscellaneous(500)
                .travel(1000)
                .debts(0)
                .savingAndInvesting(5000)
                .type(EntryType.PLAN)
                .date(LocalDate.of(2022, 4, 3))
                .user(new User())
                .build();

        //When
        entryDbService.deleteEntry(1L);

        //Then
        assertEquals(Optional.empty(), entryDbService.getEntry(1L));
    }

    @Test
    void saveEntry() {
        //Given
        Entry entry = new Entry.EntryBuilder()
                .id(1L)
                .income(10000)
                .food(700)
                .housing(1000)
                .transportation(300)
                .healthcare(400)
                .personal(400)
                .kids(800)
                .entertainment(200)
                .miscellaneous(500)
                .travel(1000)
                .debts(0)
                .savingAndInvesting(5000)
                .type(EntryType.PLAN)
                .date(LocalDate.of(2022, 4, 3))
                .user(new User())
                .build();

        when(entryRepository.findById(1L)).thenReturn(Optional.of(entry));

        //When
        entryDbService.saveEntry(entry);

        //Then
        assertEquals(1L, entryRepository.findById(1L).get().getId());
        assertEquals(10000, entryRepository.findById(1L).get().getIncome());
        assertEquals(700, entryRepository.findById(1L).get().getFood());
        assertEquals(1000, entryRepository.findById(1L).get().getHousing());
        assertEquals(300, entryRepository.findById(1L).get().getTransportation());
        assertEquals(400, entryRepository.findById(1L).get().getHealthcare());
        assertEquals(400, entryRepository.findById(1L).get().getPersonal());
        assertEquals(800, entryRepository.findById(1L).get().getKids());
        assertEquals(200, entryRepository.findById(1L).get().getEntertainment());
        assertEquals(500, entryRepository.findById(1L).get().getMiscellaneous());
        assertEquals(1000, entryRepository.findById(1L).get().getTravel());
        assertEquals(0, entryRepository.findById(1L).get().getDebts());
        assertEquals(5000, entryRepository.findById(1L).get().getSavingAndInvesting());
        assertEquals(EntryType.PLAN, entryRepository.findById(1L).get().getType());
        assertEquals(LocalDate.of(2022, 4, 3), entryRepository.findById(1L).get().getDate());
    }

}