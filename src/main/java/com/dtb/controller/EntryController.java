package com.dtb.controller;

import com.dtb.domain.Entry;
import com.dtb.domain.EntryAud;
import com.dtb.domain.EntryDto;
import com.dtb.domain.EntryType;
import com.dtb.exception.EntryNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.facade.EntryFacade;
import com.dtb.mapper.EntryMapper;
import com.dtb.repository.EntryAudRepository;
import com.dtb.service.EntryAudDbService;
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
//    private final EntryDbService entryDbService;
//    private final EntryMapper entryMapper;
    private final EntryFacade entryFacade;

    @GetMapping(value = "/entries")
    public List<EntryDto> getEntries() {
        return entryFacade.getEntries();
    }

    @GetMapping(value = "/entries/{id}")
    public EntryDto getEntry(@PathVariable Long id) throws EntryNotFoundException {
        return entryFacade.getEntry(id);
    }

    @DeleteMapping(value = "/entries/{id}")
    public void deleteEntry(@PathVariable Long id) throws EntryNotFoundException {
        entryFacade.deleteEntry(id);
    }

    @PostMapping(value = "/entries", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createEntry(@RequestBody EntryDto entryDto) throws UserNotFoundException {
        entryFacade.createEntry(entryDto);
    }

    @PutMapping(value = "/entries")
    public EntryDto updateEntry(@RequestBody EntryDto entryDto) throws UserNotFoundException, EntryNotFoundException {
        return entryFacade.updateEntry(entryDto);
    }

    @GetMapping(value = "/entries/type")
    public List<EntryDto> getEntriesByType(@RequestParam EntryType type) {
        return entryFacade.getEntriesByType(type);
    }

    @GetMapping(value = "/entries/date")
    public List<EntryDto> getEntriesByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate begin,
                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return entryFacade.getEntriesByDate(begin, end);
    }

    @GetMapping(value = "/entries/report")
    public List<EntryDto> report() {
        return entryFacade.report();
    }

    @GetMapping(value = "/entries/report/date")
    public List<EntryDto> reportByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate begin,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return entryFacade.reportByDate(begin, end);
    }
}
