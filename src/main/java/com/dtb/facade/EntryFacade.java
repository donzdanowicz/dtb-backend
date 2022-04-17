package com.dtb.facade;

import com.dtb.client.CurrencyConverterClient;
import com.dtb.domain.Entry;
import com.dtb.domain.EntryDto;
import com.dtb.domain.EntryType;
import com.dtb.exception.EntryNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.mapper.EntryMapper;
import com.dtb.service.EntryDbService;
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

    public List<EntryDto> getEntries() {
        List<Entry> entries = entryDbService.getEntries();
        return entryMapper.mapToEntryDtoList(entries);
    }

    public EntryDto getEntry(final Long id) throws EntryNotFoundException {
        return entryMapper.mapToEntryDto(
                entryDbService.getEntry(id).orElseThrow(EntryNotFoundException::new)
        );
    }

    public void deleteEntry(final Long id) {
        entryDbService.deleteEntry(id);
    }

    public void createEntry(final EntryDto entryDto) throws UserNotFoundException {
        Entry entry = entryMapper.mapToEntry(entryDto);
        entryDbService.saveEntry(entry);
    }

    public EntryDto updateEntry(final EntryDto entryDto) throws UserNotFoundException {
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
        return entryMapper.mapToEntryDtoList(reports);
    }
}
