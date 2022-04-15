package com.dtb.controller;

import com.dtb.domain.Entry;
import com.dtb.domain.EntryDto;
import com.dtb.exception.EntryNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.mapper.EntryMapper;
import com.dtb.service.EntryDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class EntryController {
    private final EntryDbService entryDbService;
    private final EntryMapper entryMapper;

    @GetMapping(value = "/entries")
    public List<EntryDto> getEntries() {
        List<Entry> entries = entryDbService.getEntries();
        return entryMapper.mapToEntryDtoList(entries);
    }

    @GetMapping(value = "/entries/{id}")
    public EntryDto getEntry(@PathVariable Long id) throws EntryNotFoundException {
        return entryMapper.mapToEntryDto(
                entryDbService.getEntry(id).orElseThrow(EntryNotFoundException::new)
        );
    }

    @DeleteMapping(value = "/entries/{id}")
    public void deleteEntry(@PathVariable Long id) {
        entryDbService.deleteEntry(id);
    }

    @PostMapping(value = "/entries", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createEntry(@RequestBody EntryDto entryDto) throws UserNotFoundException {
        Entry entry = entryMapper.mapToEntry(entryDto);
        entryDbService.saveEntry(entry);
    }

    @PutMapping(value = "/entries")
    public EntryDto updateEntry(@RequestBody EntryDto entryDto) throws UserNotFoundException {
        Entry entry = entryMapper.mapToEntry(entryDto);
        Entry updatedEntry = entryDbService.saveEntry(entry);
        return entryMapper.mapToEntryDto(updatedEntry);
    }

    @GetMapping(value = "/entries/report")
    public List<EntryDto> report() {
        List<Entry> reports = entryDbService.report();
        return entryMapper.mapToEntryDtoList(reports);
    }

    @GetMapping(value = "/entries/reportByDate")
    public List<EntryDto> report(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate begin,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        List<Entry> reports = entryDbService.reportByDate(begin, end);
        return entryMapper.mapToEntryDtoList(reports);
    }
}
