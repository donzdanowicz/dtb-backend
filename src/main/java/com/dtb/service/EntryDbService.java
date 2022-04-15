package com.dtb.service;

import com.dtb.domain.Entry;
import com.dtb.repository.EntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EntryDbService {
    private final EntryRepository entryRepository;

    public List<Entry> getEntries() {
        return entryRepository.findAll();
    }

    public Optional<Entry> getEntry(final Long id) {
        return entryRepository.findById(id);
    }

    public Entry saveEntry(final Entry entry) {
        return entryRepository.save(entry);
    }

    public void deleteEntry(final Long id) {
        entryRepository.deleteById(id);
    }

    public List<Entry> report() {
        return entryRepository.report();
    }

    public List<Entry> reportByDate(@Param("BEGIN") LocalDate begin, @Param("END") LocalDate end) {
        return entryRepository.reportByDate(begin, end);
    }
}
