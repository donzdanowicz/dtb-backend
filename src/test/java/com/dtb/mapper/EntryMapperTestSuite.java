package com.dtb.mapper;

import com.dtb.domain.Entry;
import com.dtb.domain.EntryDto;
import com.dtb.domain.EntryType;
import com.dtb.domain.User;
import com.dtb.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EntryMapperTestSuite {

    @Autowired
    private EntryMapper entryMapper;

    @Test
    public void shouldMapToEntry() throws UserNotFoundException {
        //Given
        EntryDto entryDto = new EntryDto.EntryDtoBuilder()
                .id(1L)
                .income(10000)
                .food(900)
                .housing(1000)
                .transportation(300)
                .healthcare(200)
                .personal(300)
                .kids(600)
                .entertainment(300)
                .miscellaneous(500)
                .travel(1000)
                .debts(0)
                .savingAndInvesting(4000)
                .type(EntryType.PLAN)
                .date(LocalDate.of(2022, 4, 2))
                .userId(1L)
                .build();

        //When
        Entry entry = entryMapper.mapToEntry(entryDto);

        //Then
        assertEquals(1L, entry.getId());
        assertEquals(10000, entry.getIncome());
        assertEquals(900, entry.getFood());
        assertEquals(1000, entry.getHousing());
        assertEquals(300, entry.getTransportation());
        assertEquals(200, entry.getHealthcare());
        assertEquals(300, entry.getPersonal());
        assertEquals(600, entry.getKids());
        assertEquals(300, entry.getEntertainment());
        assertEquals(500, entry.getMiscellaneous());
        assertEquals(1000, entry.getTravel());
        assertEquals(0, entry.getDebts());
        assertEquals(4000, entry.getSavingAndInvesting());
        assertEquals(EntryType.PLAN, entry.getType());
        assertEquals(LocalDate.of(2022, 4, 2), entry.getDate());
        assertEquals(1L, entry.getUser().getId());
    }

    @Test
    public void shouldMapToEntryDto() throws UserNotFoundException {
        //Given
        User user = new User(1L, "John", "Shoggoth",
                LocalDateTime.of(2022,3,22,12,33,0), "PLN", false);

        Entry entry = new Entry.EntryBuilder()
                .id(1L)
                .income(10000)
                .food(900)
                .housing(1000)
                .transportation(300)
                .healthcare(200)
                .personal(300)
                .kids(600)
                .entertainment(300)
                .miscellaneous(500)
                .travel(1000)
                .debts(0)
                .savingAndInvesting(4000)
                .type(EntryType.PLAN)
                .date(LocalDate.of(2022, 4, 2))
                .user(user)
                .build();

        //When
        EntryDto entryDto = entryMapper.mapToEntryDto(entry);

        //Then
        assertEquals(1L, entry.getId());
        assertEquals(10000, entry.getIncome());
        assertEquals(900, entry.getFood());
        assertEquals(1000, entry.getHousing());
        assertEquals(300, entry.getTransportation());
        assertEquals(200, entry.getHealthcare());
        assertEquals(300, entry.getPersonal());
        assertEquals(600, entry.getKids());
        assertEquals(300, entry.getEntertainment());
        assertEquals(500, entry.getMiscellaneous());
        assertEquals(1000, entry.getTravel());
        assertEquals(0, entry.getDebts());
        assertEquals(4000, entry.getSavingAndInvesting());
        assertEquals(EntryType.PLAN, entry.getType());
        assertEquals(LocalDate.of(2022, 4, 2), entry.getDate());
        assertEquals(1L, entry.getUser().getId());
        assertEquals(user, entry.getUser());
    }

    @Test
    public void shouldMapToEntryDtoList() {
        //Given
        User user = new User(1L, "John", "Shoggoth",
                LocalDateTime.of(2022,3,22,12,33,0), "PLN", false);

        List<Entry> entries = new ArrayList<>();

        Entry entry1 = new Entry.EntryBuilder()
                .id(1L)
                .income(10000)
                .food(900)
                .housing(1000)
                .transportation(300)
                .healthcare(200)
                .personal(300)
                .kids(600)
                .entertainment(300)
                .miscellaneous(500)
                .travel(1000)
                .debts(0)
                .savingAndInvesting(4000)
                .type(EntryType.PLAN)
                .date(LocalDate.of(2022, 4, 2))
                .user(user)
                .build();

        Entry entry2 = new Entry.EntryBuilder()
                .id(2L)
                .income(12000)
                .food(900)
                .housing(900)
                .transportation(500)
                .healthcare(300)
                .personal(400)
                .kids(500)
                .entertainment(500)
                .miscellaneous(300)
                .travel(200)
                .debts(0)
                .savingAndInvesting(5000)
                .type(EntryType.PLAN)
                .date(LocalDate.of(2022, 3, 2))
                .user(user)
                .build();

        entries.add(entry1);
        entries.add(entry2);

        //When
        List<EntryDto> entriesDto = entryMapper.mapToEntryDtoList(entries);

        //Then
        assertEquals(2, entriesDto.size());
        assertEquals(1L, entriesDto.get(0).getId());
        assertEquals(10000, entriesDto.get(0).getIncome());
        assertEquals(900, entriesDto.get(0).getFood());
        assertEquals(1000, entriesDto.get(0).getHousing());
        assertEquals(300, entriesDto.get(0).getTransportation());
        assertEquals(200, entriesDto.get(0).getHealthcare());
        assertEquals(300, entriesDto.get(0).getPersonal());
        assertEquals(600, entriesDto.get(0).getKids());
        assertEquals(500, entriesDto.get(1).getEntertainment());
        assertEquals(300, entriesDto.get(1).getMiscellaneous());
        assertEquals(200, entriesDto.get(1).getTravel());
        assertEquals(0, entriesDto.get(1).getDebts());
        assertEquals(5000, entriesDto.get(1).getSavingAndInvesting());
        assertEquals(EntryType.PLAN, entriesDto.get(1).getType());
        assertEquals(LocalDate.of(2022, 3, 2), entriesDto.get(1).getDate());
        assertEquals(1L, entriesDto.get(1).getUserId());

    }

}

