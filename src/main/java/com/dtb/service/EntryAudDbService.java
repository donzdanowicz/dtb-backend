package com.dtb.service;

import com.dtb.domain.Entry;
import com.dtb.domain.EntryAud;
import com.dtb.repository.EntryAudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EntryAudDbService {
    private final EntryAudRepository entryAudRepository;

    public EntryAud saveEntryAud(final EntryAud entryAud) {
        return entryAudRepository.save(entryAud);
    }
}
