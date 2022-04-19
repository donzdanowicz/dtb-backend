package com.dtb.facade;

import com.dtb.client.CurrencyConverterClient;
import com.dtb.domain.*;
import com.dtb.exception.EntryNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.mapper.EntryMapper;
import com.dtb.service.EntryAudDbService;
import com.dtb.service.EntryDbService;
import com.dtb.service.ReportAudDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Component
public class EntryFacade {
    @Autowired
    private EntryDbService entryDbService;
    @Autowired
    private EntryMapper entryMapper;
    @Autowired
    private EntryAudDbService entryAudDbService;
    @Autowired
    private ReportAudDbService reportAudDbService;

    public List<EntryDto> getEntries() {
        List<Entry> entries = entryDbService.getEntries();
        return entryMapper.mapToEntryDtoList(entries);
    }

    public EntryDto getEntry(final Long id) throws EntryNotFoundException {
        return entryMapper.mapToEntryDto(
                entryDbService.getEntry(id).orElseThrow(EntryNotFoundException::new)
        );
    }

    public void deleteEntry(final Long id) throws EntryNotFoundException {
        EntryAud entryAud = EntryAud.builder()
                .eventDate(LocalDate.now())
                .eventType("DELETE")
                .entryId(id)
                .oldIncome(getEntry(id).getIncome())
                .oldFood(getEntry(id).getFood())
                .oldHousing(getEntry(id).getHousing())
                .oldTransportation(getEntry(id).getTransportation())
                .oldHealthcare(getEntry(id).getHealthcare())
                .oldPersonal(getEntry(id).getPersonal())
                .oldKids(getEntry(id).getKids())
                .oldEntertainment(getEntry(id).getEntertainment())
                .oldMiscellaneous(getEntry(id).getMiscellaneous())
                .oldTravel(getEntry(id).getTravel())
                .oldDebts(getEntry(id).getDebts())
                .oldSavingAndInvesting(getEntry(id).getSavingAndInvesting())
                .oldType(getEntry(id).getType())
                .oldDate(getEntry(id).getDate())
                .oldUserId(getEntry(id).getUserId())
                .build();

        entryAudDbService.saveEntryAud(entryAud);

        entryDbService.deleteEntry(id);
    }

    public void createEntry(final EntryDto entryDto) throws UserNotFoundException {
        Entry entry = entryMapper.mapToEntry(entryDto);
        entryDbService.saveEntry(entry);

        EntryAud entryAud = EntryAud.builder()
                .eventDate(LocalDate.now())
                .eventType("INSERT")
                .entryId(getEntries().get(getEntries().size() - 1).getId())
                .newIncome(entryDto.getIncome())
                .newFood(entryDto.getFood())
                .newHousing(entryDto.getHousing())
                .newTransportation(entryDto.getTransportation())
                .newHealthcare(entryDto.getHealthcare())
                .newPersonal(entryDto.getPersonal())
                .newKids(entryDto.getKids())
                .newEntertainment(entryDto.getEntertainment())
                .newMiscellaneous(entryDto.getMiscellaneous())
                .newTravel(entryDto.getTravel())
                .newDebts(entryDto.getDebts())
                .newSavingAndInvesting(entryDto.getSavingAndInvesting())
                .newType(entryDto.getType())
                .newDate(entryDto.getDate())
                .newUserId(entryDto.getUserId())
                .build();

        entryAudDbService.saveEntryAud(entryAud);
    }

    public EntryDto updateEntry(final EntryDto entryDto) throws UserNotFoundException, EntryNotFoundException {
        Long id = entryDto.getId();

        EntryAud entryAud = EntryAud.builder()
                .eventDate(LocalDate.now())
                .eventType("UPDATE")
                .entryId(entryDto.getId())
                .newIncome(entryDto.getIncome())
                .newFood(entryDto.getFood())
                .newHousing(entryDto.getHousing())
                .newTransportation(entryDto.getTransportation())
                .newHealthcare(entryDto.getHealthcare())
                .newPersonal(entryDto.getPersonal())
                .newKids(entryDto.getKids())
                .newEntertainment(entryDto.getEntertainment())
                .newMiscellaneous(entryDto.getMiscellaneous())
                .newTravel(entryDto.getTravel())
                .newDebts(entryDto.getDebts())
                .newSavingAndInvesting(entryDto.getSavingAndInvesting())
                .newType(entryDto.getType())
                .newDate(entryDto.getDate())
                .newUserId(entryDto.getUserId())
                .oldIncome(getEntry(id).getIncome())
                .oldFood(getEntry(id).getFood())
                .oldHousing(getEntry(id).getHousing())
                .oldTransportation(getEntry(id).getTransportation())
                .oldHealthcare(getEntry(id).getHealthcare())
                .oldPersonal(getEntry(id).getPersonal())
                .oldKids(getEntry(id).getKids())
                .oldEntertainment(getEntry(id).getEntertainment())
                .oldMiscellaneous(getEntry(id).getMiscellaneous())
                .oldTravel(getEntry(id).getTravel())
                .oldDebts(getEntry(id).getDebts())
                .oldSavingAndInvesting(getEntry(id).getSavingAndInvesting())
                .oldType(getEntry(id).getType())
                .oldDate(getEntry(id).getDate())
                .oldUserId(getEntry(id).getUserId())
                .build();

        entryAudDbService.saveEntryAud(entryAud);

        Entry entry = entryMapper.mapToEntry(entryDto);
        Entry updatedEntry = entryDbService.saveEntry(entry);



        return entryMapper.mapToEntryDto(updatedEntry);
    }

    public List<EntryDto> getEntriesByType(final EntryType type) {
        List<Entry> entriesByType = entryDbService.getEntriesByType(type);
        return entryMapper.mapToEntryDtoList(entriesByType);
    }

    public List<EntryDto> getEntriesByDate(final LocalDate begin,
                                           final LocalDate end) {
        List<Entry> entriesByDate = entryDbService.getEntriesByDateBetween(begin, end);
        return entryMapper.mapToEntryDtoList(entriesByDate);
    }

    public List<EntryDto> report() {
        List<Entry> reports = entryDbService.report();
        return entryMapper.mapToEntryDtoList(reports);
    }

    public List<EntryDto> reportByDate(final LocalDate begin,
                                       final LocalDate end) {
        List<Entry> reports = entryDbService.reportByDate(begin, end);

        for (Entry entryDto: reports) {

        ReportAud reportAud = ReportAud.builder()
                .eventDate(LocalDate.now())
                .income(entryDto.getIncome())
                .food(entryDto.getFood())
                .housing(entryDto.getHousing())
                .transportation(entryDto.getTransportation())
                .healthcare(entryDto.getHealthcare())
                .personal(entryDto.getPersonal())
                .kids(entryDto.getKids())
                .entertainment(entryDto.getEntertainment())
                .miscellaneous(entryDto.getMiscellaneous())
                .travel(entryDto.getTravel())
                .debts(entryDto.getDebts())
                .savingAndInvesting(entryDto.getSavingAndInvesting())
                .type(entryDto.getType())
                .fromDate(begin)
                .toDate(end)
                .userId(entryDto.getUser().getId())
                .build();


        reportAudDbService.saveReportAud(reportAud);
        }

        return entryMapper.mapToEntryDtoList(reports);
    }
}
